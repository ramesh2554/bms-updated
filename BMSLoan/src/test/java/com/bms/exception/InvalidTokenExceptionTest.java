package com.bms.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvalidTokenExceptionTest {

	

	@Test
	 void testInvalidTokenException()
	{
		InvalidTokenException invalidTokenException =new InvalidTokenException("Invalid Token");
		assertEquals("Invalid Token", invalidTokenException.getMessage());
	}
}
