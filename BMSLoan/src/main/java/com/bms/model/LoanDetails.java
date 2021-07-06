package com.bms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(mappedBy = "loanDetails")
	private Loan loan_no;
	private Double courseFee;
	private String course;
	private String fatherName;
	private String fatherOccupation;
	private Integer fatherTotalExp;
	private Integer fatherCurrentCompanyExp;
	private String rationCard;
	private Double fatherAnnualIncome;
	private Double annualIncome;
	private String companyName;
	private String designation;
	private Integer totalExp;
	private Integer expWithCurrentCompany;

	public LoanDetails(Double annualIncome, String companyName, String designation, Integer totalExp,
			Integer expWithCurrentCompany) {
		super();
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expWithCurrentCompany = expWithCurrentCompany;
	}

}
