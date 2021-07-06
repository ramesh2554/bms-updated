package com.bms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bms.dao.LoanDao;
import com.bms.exception.InvalidTokenException;
import com.bms.model.Loan;
import com.bms.model.LoanDetails;
import com.bms.model.ValidateToken;
import com.bms.restclients.AuthFeign;

@SpringBootTest
class LoanServiceImplTest {

	@InjectMocks
	LoanServiceImpl service;

	@Mock
	LoanDao loanDao;

	@Mock
	AuthFeign authFeign;

	@Test
	void testApplyEducationLoan() throws InvalidTokenException {

		LoanDetails loanDetails = new LoanDetails(10000d, "Cts", "PAt", 5, 4);

		Loan loan = new Loan();
		loan.setCid("R-123");
		loan.setRateOfInterest(0.75);
		loan.setStatus("Applied");
		loan.setLoan_no("L-1234");
		loan.setApplyDate(LocalDate.now());
		loan.setType("Education");
		loan.setAmount(10000l);
		loan.setDurationInYears(5);
		loan.setLoanDetails(loanDetails);
		ValidateToken tokenValid = new ValidateToken("uid", "name", true);
		ResponseEntity<ValidateToken> response = new ResponseEntity<ValidateToken>(tokenValid, HttpStatus.OK);
		when(authFeign.getValidity("token")).thenReturn(response);
		when(loanDao.save(loan)).thenReturn(loan);
		assertEquals(400, service.applyLoan(loan, "R-001", "token").getStatusCodeValue());
	}

	@Test
	void testApplyPesonalLoan() throws InvalidTokenException {

		LoanDetails loanDetails = new LoanDetails(10000d, "Cts", "PAt", 5, 4);

		Loan loan = new Loan();
		loan.setCid("R-123");
		loan.setRateOfInterest(2);
		loan.setStatus("Applied");
		loan.setLoan_no("L-3214");
		loan.setApplyDate(LocalDate.now());
		loan.setType("Personal");
		loan.setAmount(10000l);
		loan.setDurationInYears(5);
		loan.setLoanDetails(loanDetails);
		ValidateToken tokenValid = new ValidateToken("uid", "name", true);
		ResponseEntity<ValidateToken> response = new ResponseEntity<ValidateToken>(tokenValid, HttpStatus.OK);
		when(authFeign.getValidity("token")).thenReturn(response);
		when(loanDao.save(loan)).thenReturn(loan);
		assertEquals(200, service.applyLoan(loan, "R-001", "token").getStatusCodeValue());
	}

	@Test
	void testApplyHomeLoan() throws InvalidTokenException {

		LoanDetails loanDetails = new LoanDetails(10000d, "Cts", "PAt", 5, 4);

		Loan loan = new Loan();
		loan.setCid("R-123");
		loan.setRateOfInterest(1.5);
		loan.setStatus("Applied");
		loan.setLoan_no("L-3214");
		loan.setApplyDate(LocalDate.now());
		loan.setType("Home");
		loan.setAmount(10000l);
		loan.setDurationInYears(5);
		loan.setLoanDetails(loanDetails);
		ValidateToken tokenValid = new ValidateToken("uid", "name", true);
		ResponseEntity<ValidateToken> response = new ResponseEntity<ValidateToken>(tokenValid, HttpStatus.OK);
		when(authFeign.getValidity("token")).thenReturn(response);
		when(loanDao.save(loan)).thenReturn(loan);
		assertEquals(200, service.applyLoan(loan, "R-001", "token").getStatusCodeValue());
	}

}
