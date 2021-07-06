package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bms.exception.InvalidTokenException;
import com.bms.model.Loan;
import com.bms.service.LoanService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BMSApplyLoan {

	@Autowired
	private LoanService loanService;

	@PostMapping(value = "/loan/{customer_id}/applyLoan")
	public ResponseEntity<Object> applyLoan(@RequestHeader("Authorization") String token, @RequestBody Loan loan,
			@PathVariable String customer_id) throws InvalidTokenException {
		log.info("Start");
		log.info("Custome ApplyLoan");
		log.info("End");
		return loanService.applyLoan(loan, customer_id, token);
	}

}
