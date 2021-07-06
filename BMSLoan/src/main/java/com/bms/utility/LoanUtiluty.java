package com.bms.utility;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.bms.model.LoanDetails;
import com.bms.model.ResponseMessage;

public class LoanUtiluty {

	public static List<String> validateHomeLoan(LoanDetails loan) {

		List<String> error = new ArrayList<>();
		if (loan.getAnnualIncome() == null) {
			error.add("AnnualIncome");
		}
		if (loan.getCompanyName() == null) {
			error.add("companyName");
		}
		if (loan.getDesignation() == null) {
			error.add("designation");
		}
		if (loan.getTotalExp() == null) {
			error.add("TotalExp");
		}
		if (loan.getExpWithCurrentCompany() == null) {
			error.add("ExpWithCurrentCompany");
		}

		return error;

	}

	public static List<String> validateEducationLoan(LoanDetails loan) {
		List<String> error = new ArrayList<>();

		if (loan.getCourseFee() == null) {
			error.add("Course Fee");
		}
		if (loan.getCourse() == null) {
			error.add("Course");
		}
		if (loan.getFatherName() == null) {
			error.add("Father Name");
		}
		if (loan.getFatherOccupation() == null) {
			error.add("Father Occupation");
		}
		if (loan.getFatherTotalExp() == null) {
			error.add("Father Total Experiance");
		}
		if (loan.getFatherCurrentCompanyExp() == null) {
			error.add("Father Current Company Experiance");
		}
		if (loan.getRationCard() == null) {
			error.add("Ration Card ");
		}
		if (loan.getFatherAnnualIncome() == null) {
			error.add("Father Annual Income ");
		}
		return error;
	}
	
	
	public static ResponseMessage prepareErrorMessage(List<String> errors) {

		String finalMessage = String.join(", ", errors) + " feilds are mandatory";
		return new ResponseMessage(finalMessage, LocalDateTime.now(), HttpStatus.BAD_REQUEST);

	}

}
