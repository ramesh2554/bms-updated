package com.bms.utiluty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.bms.model.Loan;
import com.bms.model.LoanDetails;
import com.bms.utility.LoanUtiluty;

class LoanUtilutyTest {

	@Test
	void testValidateHomeLoan() {
		LoanDetails loan = new LoanDetails();
		loan.setAnnualIncome(null);
		loan.setCompanyName(null);
		loan.setDesignation(null);
		loan.setTotalExp(null);
		loan.setExpWithCurrentCompany(null);
		List<String> error = new ArrayList<>();
		error.add("AnnualIncome");
		error.add("companyName");
		error.add("designation");
		error.add("TotalExp");
		error.add("ExpWithCurrentCompany");
		assertEquals(error, LoanUtiluty.validateHomeLoan(loan));
	}

	@Test
	void testValidateEducationLoan() {
		LoanDetails loan = new LoanDetails();
		loan.setCourseFee(null);
		loan.setCourse(null);
		loan.setFatherName(null);
		loan.setFatherOccupation(null);
		loan.setFatherTotalExp(null);
		loan.setFatherCurrentCompanyExp(null);
		loan.setRationCard(null);
		loan.setFatherAnnualIncome(null);

		List<String> error = new ArrayList<>();
		error.add("Course Fee");
		error.add("Course");
		error.add("Father Name");
		error.add("Father Occupation");
		error.add("Father Total Experiance");
		error.add("Father Current Company Experiance");
		error.add("Ration Card ");
		error.add("Father Annual Income ");
		assertEquals(error, LoanUtiluty.validateEducationLoan(loan));
	}

}
