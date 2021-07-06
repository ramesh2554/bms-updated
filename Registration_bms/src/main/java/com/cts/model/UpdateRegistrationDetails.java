package com.cts.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cts.validatator.AccountType;
import com.cts.validatator.GenderType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRegistrationDetails {

	@Id
	@JsonIgnore
	private String customer_id;
	@JsonIgnore
	private String accountNumber;

	@NotBlank(message = "Name  is mandatory ")
	@Pattern(regexp = "[a-zA-Z ]*$", message = "Customer Name  should contain only alphabets and space")
	private String name;

	@NotBlank(message = "Guardian Type is mandatory ")
	@Pattern(regexp = "[a-zA-Z ]*$", message = "Guardian Type should contain only alphabets and space")
	private String guardianType;
	@NotBlank(message = "Guardian Name is mandatory ")
	@Pattern(regexp = "[a-zA-Z ]*$", message = "Guardian Name should contain only alphabets and space")
	private String guardianName;

	@NotBlank(message = "Address Name is mandatory ")
	private String address;
	@NotBlank(message = "CitizenShip is mandatory ")
	private String citizenship;
	@NotBlank(message = "state Name is mandatory ")
	private String state;

	@NotBlank(message = "country Name is mandatory ")
	private String country;

	@NotBlank(message = "Email is mandatory ")
	@Email(regexp = ".+@.+\\..+")
	private String emailAddress;

	@NotBlank(message = "gender Name is mandatory ")
	@GenderType
	private String gender;

	@NotBlank(message = "maritalStatus Name is mandatory ")
	private String maritalStatus;

	@NotBlank(message = "Contact Number  is mandatory ")
	@Pattern(regexp = "[7-9]{1}[0-9]{9}", message = "Contact Number should contain only 10 digitis")
	private String contactNumber;

	@NotNull(message = "Date Of Birth  is mandatory ")
	@Past
	private Date dob;
	@JsonIgnore
	private LocalDate registrationDate;

	@JsonIgnore
	private String citizenStatus;

	@NotBlank(message = "Identification Proof Type  is mandatory ")
	private String identificationProofType;

	@NotBlank(message = "Identification Document Number  is mandatory ")
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-z]{1}", message = "Enter valid Pan Card Number ")
	private String identificationDocumentNo;

	@NotBlank(message = "Reference Account Holder Name mandatory ")
	@Pattern(regexp = "[a-zA-Z ]*$", message = "Account Holder Name should contain only alphabets and space")
	private String referenceAccountHolderName;

	@NotBlank(message = "Reference Account Holder Account Number  is mandatory ")
	private String referenceAccountHolderAccountNo;

	@NotBlank(message = "reference Account Holder Address  is mandatory ")
	private String referenceAccountHolderAddress;

	@NotBlank(message = "Account Type  is mandatory ")
	@AccountType
	private String accountType;

	@NotBlank(message = "Bank Name is mandatory ")
	private String bankName;

	@NotBlank(message = "Branch Name  is mandatory ")
	@Size(min = 3, message = "Branch Name Atleast 3 Characters long")
	private String branchName;

}