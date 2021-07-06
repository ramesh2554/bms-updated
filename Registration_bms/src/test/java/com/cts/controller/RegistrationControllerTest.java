package com.cts.controller;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.cts.dao.RegistrationRepo;
import com.cts.model.RegistrationDetails;
import com.cts.model.UpdateRegistrationDetails;
import com.cts.service.RegistrationServiceImpl;

@SpringBootTest
class RegistrationControllerTest {

	@Mock
	RegistrationController registrationController;

	@InjectMocks
	RegistrationServiceImpl registrationServiceImpl;

	RegistrationDetails details;

	@Mock
	RegistrationRepo registrationRepo;

	@Test
	void registrationPage() throws Exception {
		RegistrationDetails details = new RegistrationDetails("R-215", "1234567812345678", "yashu", "yashu",
				"Yashu@123", "father", "raju", "3-35/2", "india", "andhra", "india", "yashu@gmail.com", "female",
				"unmarried", "9603853430", null, LocalDate.now(), "NORMAL", "PAN", "JCUPK1234D", "Ramesh", "123456",
				"same", "savings", "Indain", "jrg", 5000);

		details = new RegistrationDetails();
		details.setCustomer_id("R-327");
		details.setAccountNumber("2895411610795515");
		details.setName("yashu");
		details.setPassword("yashu@123");
		details.setUsername("yashu");
		details.setGuardianType("father");
		details.setGuardianName("raju");
		details.setAddress("1-57,Main Road");
		details.setCitizenship("Indian");
		details.setState("andhra");
		details.setCountry("India");
		details.setEmailAddress("yashu@gmail.com");
		details.setGender("female");
		details.setMaritalStatus("unmarried");
		details.setContactNumber("9493430753");
		details.setDob(new Date(2010, 01, 02));
		details.setRegistrationDate(LocalDate.now());
		details.setCitizenStatus("MINIOR");
		details.setIdentificationProofType("PAN");
		details.setIdentificationDocumentNo("JCUPK3434A");
		details.setReferenceAccountHolderName("raju");
		details.setReferenceAccountHolderAccountNo("12345");
		details.setReferenceAccountHolderAddress("same");
		details.setAccountType("Savings");
		details.setBankName("Indian  Bank");
		details.setBranchName("JRG main Branch");
		details.setInitialDepositAmount(5000);

		details = new RegistrationDetails("R-215", "1234567812345678", "yashu", "yashu", "Yashu@123", "father", "raju",
				"3-35/2", "india", "andhra", "india", "yashu@gmail.com", "female", "unmarried", "9603853430", null,
				LocalDate.now(), "NORMAL", "PAN", "JCUPK1234D", "Ramesh", "123456", "same", "savings", "Indain", "jrg",
				5000);

		ResponseEntity<Object> registrationPage = registrationController.registrationPage(details);

	}

	@Test
	void updationPage() throws Exception {
		UpdateRegistrationDetails details = new UpdateRegistrationDetails("R-215", "1234567812345678", "yashu",
				"father", "raju", "3-35/2", "india", "andhra", "india", "yashu@gmail.com", "female", "unmarried",
				"9603853430", null, LocalDate.now(), "NORMAL", "PAN", "JCUPK1234D", "raju", "123456", "same", "savings",
				"Indian bank", "JRc Mainroad");

		details = new UpdateRegistrationDetails();
		details.setCustomer_id("R-215");
		details.setAccountNumber("2895411610795515");
		details.setName("yashu");
		details.setGuardianType("father");
		details.setGuardianName("raju");
		details.setAddress("1-57,Main Road");
		details.setCitizenship("Indian");
		details.setState("andhra");
		details.setCountry("India");
		details.setEmailAddress("yashu@gmail.com");
		details.setGender("female");
		details.setMaritalStatus("unmarried");
		details.setContactNumber("9493430753");
		details.setDob(new Date(2010, 01, 02));
		details.setRegistrationDate(LocalDate.now());
		details.setCitizenStatus("MINIOR");
		details.setIdentificationProofType("PAN");
		details.setIdentificationDocumentNo("JCUPK3434A");
		details.setReferenceAccountHolderName("raju");
		details.setReferenceAccountHolderAccountNo("12345");
		details.setReferenceAccountHolderAddress("same");
		details.setAccountType("Savings");
		details.setBankName("Indian  Bank");
		details.setBranchName("JRG main Branch");
		// details.setInitialDepositAmount(5000);

		details = new UpdateRegistrationDetails("R-215", "1234567812345678", "yashu", "father", "raju", "3-35/2",
				"india", "andhra", "india", "yashu@gmail.com", "female", "unmarried", "9603853430", null,
				LocalDate.now(), "NORMAL", "PAN", "JCUPK1234D", "raju", "123456", "same", "savings", "Indian bank",
				"JRc Mainroad");

		ResponseEntity<Object> registrationPage = registrationController.editDetails("token", details, "yashu");

	}

}
