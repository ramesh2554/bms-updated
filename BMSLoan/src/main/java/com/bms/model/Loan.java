package com.bms.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.bms.validation.LoanType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Loan {
	@Id
	@JsonIgnore
	private String loan_no;
	@JsonIgnore
	private String cid;
	@NotBlank (message = "Loan Type is Manidatory")
	@LoanType
	private String type;
	
	@Positive
	private Long amount;
	
	@JsonIgnore
	private LocalDate applyDate;
	
	@JsonIgnore
	private Date issueDate;
	
	@JsonIgnore
	
	private double rateOfInterest;
	
//	@Pattern(regexp = "[5|10|15|20]*$", message = "5 10 15 20")
//	@NotBlank(message = "not empty")
	private Integer durationInYears;
	
	@JsonIgnore
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loan_detail_id", referencedColumnName = "id")
	private LoanDetails loanDetails;

}
