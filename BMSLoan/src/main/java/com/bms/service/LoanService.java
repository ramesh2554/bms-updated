package com.bms.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bms.exception.InvalidTokenException;
import com.bms.model.Loan;

@Service
public interface LoanService {

	public ResponseEntity<Object> applyLoan(Loan loan,String cid,String token) throws InvalidTokenException;
}
