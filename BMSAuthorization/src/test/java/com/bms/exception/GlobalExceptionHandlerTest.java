package com.bms.exception;

import org.mockito.InjectMocks;
import org.mockito.Mock;

class GlobalExceptionHandlerTest {

	@InjectMocks
	GlobalExceptionHandler customizedExceptionHandling;
	
	@Mock
	UnauthorizedException unauthorizedException;
	
	
	
//	@Test
//	 void handleUnauthorizedExceptionsTest()
//	{
//		ResponseEntity<?> responseEntity= customizedExceptionHandling.handleUnauthorizedExceptions(unauthorizedException);
//		
//		
//		assertEquals(responseEntity , responseEntity.getStatusCodeValue());
//		
//	}
	
	
	

}
