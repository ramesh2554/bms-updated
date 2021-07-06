package com.bms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoanDetailsTest {

//	@Test
//	void testLoan_no() {
//		loan.setLoan_no("L-1234");
//		assertEquals("L-1234", loan.getLoan_no());
//	}
	
	Loan l = new Loan();
	LoanDetails loanDetails = new LoanDetails();

	@Test
	void testId() {
		loanDetails.setId(1);
		assertEquals(1, loanDetails.getId());
	}
	@Test
	void testLoanNo() {
		loanDetails.setLoan_no(l);
		assertEquals(l, loanDetails.getLoan_no());
	}
	@Test
	void testCourse() {
		loanDetails.setCourse("B.tech");
		assertEquals("B.tech", loanDetails.getCourse());
	}
	@Test
	void testCourseFee() {
		loanDetails.setCourseFee(10000d);
		assertEquals(10000d, loanDetails.getCourseFee());
	}
	
	
	@Test
	void testFatherName() {
		loanDetails.setFatherName("Ramesh");
		assertEquals("Ramesh", loanDetails.getFatherName());
	}
	@Test
	void testFatherOccupation() {
		loanDetails.setFatherOccupation("Business");
		assertEquals("Business", loanDetails.getFatherOccupation());
	}
	@Test
	void testFatherTotalExp() {
		loanDetails.setFatherTotalExp(25);
		assertEquals(25, loanDetails.getFatherTotalExp());
	}
	@Test
	void testFatherCurrentCompanyExp() {
		loanDetails.setFatherCurrentCompanyExp(10);
		assertEquals(10, loanDetails.getFatherCurrentCompanyExp());
	}
	
	@Test
	void testRationCard() {
		loanDetails.setRationCard("WAP1234");
		assertEquals("WAP1234", loanDetails.getRationCard());
	}
	@Test
	void testAnnualIncome() {
		loanDetails.setAnnualIncome(100000d);
		assertEquals(100000d, loanDetails.getAnnualIncome());
	}
	@Test
	void testFatherAnnualIncome() {
		loanDetails.setFatherAnnualIncome(10000d);
		assertEquals(10000d, loanDetails.getFatherAnnualIncome());
	}
	@Test
	void testCompanyName() {
		loanDetails.setCompanyName("CTS");
		assertEquals("CTS", loanDetails.getCompanyName());
	}
	@Test
	void testDesignation() {
		loanDetails.setDesignation("PAT");
		assertEquals("PAT", loanDetails.getDesignation());
	}
	@Test
	void testTotalExp() {
		loanDetails.setTotalExp(6);
		assertEquals(6, loanDetails.getTotalExp());
	}
	@Test
	void testExpWithCurrentCompany() {
		loanDetails.setExpWithCurrentCompany(5);
		assertEquals(5, loanDetails.getExpWithCurrentCompany());
	}
	
}
