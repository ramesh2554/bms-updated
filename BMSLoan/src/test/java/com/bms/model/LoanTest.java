package com.bms.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class LoanTest {

	LoanDetails loanDeatils;

	Loan loan = new Loan();
	Loan loan1 = new Loan("L-1234", "R-237", "Education", 100000l, LocalDate.now(), null, 1.5, 5, "applied",
			loanDeatils);

	@Test
	void testLoan_no() {
		loan.setLoan_no("L-1234");
		assertEquals("L-1234", loan.getLoan_no());
	}

	@Test
	void testCid() {
		loan.setCid("R-217");
		assertEquals("R-217", loan.getCid());
	}

	@Test
	void testType() {
		loan.setType("Education");
		assertEquals("Education", loan.getType());
	}

	@Test
	void testAmount() {
		loan.setAmount(10000l);
		assertEquals(10000l, loan.getAmount());
	}

	@Test
	void testApplyDate() {
		loan.setApplyDate(LocalDate.now());
		assertEquals(LocalDate.now(), loan.getApplyDate());
	}

	@Test
	void testIssueDate() {
		loan.setIssueDate(null);
		assertEquals(null, loan.getIssueDate());
	}

	@Test
	void testRateOfInterest() {
		loan.setRateOfInterest(1.5);
		assertEquals(1.5, loan.getRateOfInterest());
	}

	@Test
	void testDurationInYears() {
		loan.setDurationInYears(5);
		assertEquals(5, loan.getDurationInYears());
	}

	@Test
	void testStatus() {
		loan.setStatus("Applied");
		assertEquals("Applied", loan.getStatus());
	}

	@Test
	void testLoanDetails() {
		loan.setLoanDetails(loanDeatils);
		assertEquals(loanDeatils, loan.getLoanDetails());
	}
	
	@Test
	void testLoanToString() {
		String toString = loan.toString();
		assertEquals(toString, loan.toString());
	}

}
