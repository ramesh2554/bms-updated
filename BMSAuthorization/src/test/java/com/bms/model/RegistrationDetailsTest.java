package com.bms.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class RegistrationDetailsTest {

	RegistrationDetails details1 = new RegistrationDetails("R-215", "1234567812345678","ramesh", "ramesh1234",
			"ramesh1234@", "father", "ramesh", "3-35/2", "india", "andhra", "india", "temp@gmail.com", "male",
			"unmarried", "9603853430", null, LocalDate.now(), "NORMAL", "PAN", "JCUPK1234D", "Ramesh", "123456",
			"same", "savings", "Indain", "jrg", 5000);
	
	RegistrationDetails details = new RegistrationDetails();
	
	
	@Test
	void testCustomerId() {
		details.setCustomer_id("R-215");
		assertEquals( "R-215", details.getCustomer_id());
	}
	@Test
	void testAccountNumber() {
		details.setAccountNumber("1234567812345678");
		assertEquals( "1234567812345678", details.getAccountNumber());
	}
	
	@Test
	void testName() {
		details.setName("ramesh");
		assertEquals( "ramesh", details.getName());
	}
	@Test
	void testUsername() {
		details.setUsername("ramesh1234");
		assertEquals( "ramesh1234", details.getUsername());
	}
	@Test
	void testPassword() {
		details.setPassword("ramesh1234@");
		assertEquals( "ramesh1234@", details.getPassword());
	}
	@Test
	void testGurdianName() {
		details.setGuardianName("ramesh");
		assertEquals( "ramesh", details.getGuardianName());
	}
	@Test
	void testGurdianType() {
		details.setGuardianType("father");
		assertEquals( "father", details.getGuardianType());
	}
	
	@Test
	void testAddress() {
		details.setAddress("3-35/2");
		assertEquals( "3-35/2", details.getAddress());
	}
	@Test
	void testCitizenship() {
		details.setCitizenship("Indian");
		assertEquals( "Indian", details.getCitizenship());
	}
	@Test
	void testState() {
		details.setState("Andhra");
		assertEquals( "Andhra", details.getState());
	}
	@Test
	void testCountry() {
		details.setCountry("India");
		assertEquals( "India", details.getCountry());
	}
	
	@Test
	void testEmailAddress() {
		details.setEmailAddress("temp@gmail.com");
		assertEquals( "temp@gmail.com", details.getEmailAddress());
	}
	@Test
	void testGender() {
		details.setGender("Male");
		assertEquals( "Male", details.getGender());
	}
	@Test
	void testMaritalStatus() {
		details.setMaritalStatus("UnMarried");
		assertEquals( "UnMarried", details.getMaritalStatus());
	}
	@Test
	void testContactNumber() {
		details.setContactNumber("9090909090");
		assertEquals( "9090909090", details.getContactNumber());
	}
	@Test
	void testDob() {
		details.setDob(null);
		assertEquals( null, details.getDob());
	}
	@Test
	void testRegistrationDate() {
		details.setRegistrationDate(LocalDate.now());
		assertEquals( LocalDate.now(), details.getRegistrationDate());
	}
	@Test
	void testCitizenStatus() {
		details.setCitizenStatus("NORMAL");
		assertEquals("NORMAL", details.getCitizenStatus());
	}
	
	@Test
	void testIdentificationProofType() {
		details.setIdentificationProofType("PAN");
		assertEquals("PAN", details.getIdentificationProofType());
	}
	@Test
	void testIdentificationDocumentNo() {
		details.setIdentificationDocumentNo("ABCD1234E");
		assertEquals("ABCD1234E", details.getIdentificationDocumentNo());
	}
	@Test
	void testReferenceAccountHolderName() {
		details.setReferenceAccountHolderName("ramesh");
		assertEquals("ramesh", details.getReferenceAccountHolderName());
	}
	@Test
	void testReferenceAccountHolderAddress() {
		details.setReferenceAccountHolderAddress("Same");
		assertEquals("Same", details.getReferenceAccountHolderAddress());
	}
	@Test
	void testReferenceAccountHolderAccountNo() {
		details.setReferenceAccountHolderAccountNo("123456");
		assertEquals("123456", details.getReferenceAccountHolderAccountNo());
	}
	@Test
	void testSetAccountType() {
		details.setAccountType("Savings");
		assertEquals("Savings", details.getAccountType());
	}
	@Test
	void testBankName() {
		details.setBankName("IDFC");
		assertEquals("IDFC", details.getBankName());
	}
	@Test
	void testBranchName() {
		details.setBranchName("Jrg");
		assertEquals("Jrg", details.getBranchName());
	}
	
	@Test
	void testInitialDepositAmount() {
		details.setInitialDepositAmount(5000);
		assertEquals(5000, details.getInitialDepositAmount());
	}
	
	@Test
	void testToString() {
		details1.toString();
		assertEquals(details1.toString(), details1.toString());
	}

}
