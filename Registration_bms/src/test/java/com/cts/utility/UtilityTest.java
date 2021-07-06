package com.cts.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class UtilityTest {

	@Test
	void testGetAge() throws Exception {
		String sDate1 = "31/12/1998";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		assertEquals(22, Utility.getAge(date1));
	}

	@Test
	void testGenerateAccountNum() {
		String generateAccountNum = Utility.generateAccountNum();
		assertEquals(generateAccountNum, generateAccountNum);
	}

	@Test
	void testPasswordRegexPass() {
		String password = "Ramesh@123";
		assertEquals(true, Utility.passwordRegex(password));
	}
	
	@Test
	void testPasswordRegexFail() {
		String password = "Ramesh123";
		assertEquals(false, Utility.passwordRegex(password));
	}

}
