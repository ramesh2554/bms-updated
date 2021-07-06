package com.bms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateTokenTest {

	ValidateToken token = new ValidateToken();
	ValidateToken validateToken = new ValidateToken("Ramesh123", "rameswara", true);

	@Test
	void testUsername() {
		token.setName("rameswara");
		assertEquals("rameswara", token.getName());
	}

	@Test
	void testUid() {
		token.setUid("Ramesh123");
		assertEquals("Ramesh123", token.getUid());
	}

	@Test
	void testIsValid() {
		token.setValid(true);
		assertEquals(true, token.isValid());
	}
}
