package com.bms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bms.dao.LoanDao;
import com.bms.exception.InvalidTokenException;
import com.bms.model.Loan;
import com.bms.model.RateOfInterest;
import com.bms.model.ResponseMessage;
import com.bms.restclients.AuthFeign;
import com.bms.utility.LoanUtiluty;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDao loanDao;
	@Autowired
	private AuthFeign authFeign;

	static Random random = new Random();

	@Override
	public ResponseEntity<Object> applyLoan(Loan loan, String cid, String token) throws InvalidTokenException {
		if (authFeign.getValidity(token).getBody().isValid()) {
			loan.setLoan_no("L-" + (random.nextInt(10000)));
			loan.setApplyDate(LocalDate.now());
			RateOfInterest rate;

			if (loan.getDurationInYears() == 5 || loan.getDurationInYears() == 10 || loan.getDurationInYears() == 15
					|| loan.getDurationInYears() == 20) {
				loan.setDurationInYears(loan.getDurationInYears());
			} else {
				return new ResponseEntity<>(new ResponseMessage("Duration of Loan can be 5,10,15,20 years only",
						LocalDateTime.now(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
			}

			if (loan.getAmount() == null) {
				return new ResponseEntity<>(
						new ResponseMessage("Amount is manidatory", LocalDateTime.now(), HttpStatus.BAD_REQUEST),
						HttpStatus.BAD_REQUEST);
			}
			if (loan.getDurationInYears() == null) {
				return new ResponseEntity<>(new ResponseMessage("Duration In Years  is manidatory", LocalDateTime.now(),
						HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
			}
//			if (loan.getDurationInYears() != 5 || loan.getDurationInYears() != 10 || loan.getDurationInYears() != 15
//					|| loan.getDurationInYears() != 20) {
//				return new ResponseEntity<>(new ResponseMessage("Duration of Loan can be 5,10,15,20 years only",
//						LocalDateTime.now(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
//			}
			if (loan.getType() == null) {
				return new ResponseEntity<>(
						new ResponseMessage("Type of loan is manidatory", LocalDateTime.now(), HttpStatus.BAD_REQUEST),
						HttpStatus.BAD_REQUEST);
			} else {

				if (loan.getType().equalsIgnoreCase("Education")) {
					List<String> validateEducationLoan = LoanUtiluty.validateEducationLoan(loan.getLoanDetails());
					if (!validateEducationLoan.isEmpty()) {
						return new ResponseEntity<>(LoanUtiluty.prepareErrorMessage(validateEducationLoan),
								HttpStatus.BAD_REQUEST);
					}
					rate = RateOfInterest.EDUCATION;
				} else if (loan.getType().equalsIgnoreCase("Personal")) {

					List<String> validatePersonalLoan = LoanUtiluty.validateHomeLoan(loan.getLoanDetails());
					if (!validatePersonalLoan.isEmpty()) {
						return new ResponseEntity<>(LoanUtiluty.prepareErrorMessage(validatePersonalLoan),
								HttpStatus.BAD_REQUEST);
					}

					rate = RateOfInterest.PERSONAL;
				} else {

					List<String> validatePersonalLoan = LoanUtiluty.validateHomeLoan(loan.getLoanDetails());
					if (!validatePersonalLoan.isEmpty()) {
						return new ResponseEntity<>(LoanUtiluty.prepareErrorMessage(validatePersonalLoan),
								HttpStatus.BAD_REQUEST);
					}

					rate = RateOfInterest.HOME;
				}

				loan.setRateOfInterest(rate.getRateOfInterest());
				loan.setCid(cid);
				loan.setStatus("applied");
				loanDao.save(loan);
				log.info("Loan applied successfully");
				return new ResponseEntity<>(loan, HttpStatus.OK);

			}
		} else {
			log.error("Unautherized access");
			return new ResponseEntity<>(
					new ResponseMessage("Access Denied ,  UNAUTHORIZED", LocalDateTime.now(), HttpStatus.UNAUTHORIZED),
					HttpStatus.UNAUTHORIZED);
		}

	}

}
