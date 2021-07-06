package com.cts.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


class ResponseMessageTest {
			
	
	ResponseMessage msg = new ResponseMessage();
	
	ResponseMessage msg1 = new ResponseMessage("error",LocalDateTime.now(), HttpStatus.ACCEPTED);
	
	@Test
	void testMsg() {
		msg.setMessage("Error Occured");
		assertEquals( "Error Occured", msg.getMessage());
	}


	
	@Test
	void testDate() {
		LocalDateTime date = LocalDateTime.now(); 
		msg.setTimestamp(date);
		assertEquals( date, msg.getTimestamp());
	}
	@Test
	void testStatusCode() {
		 
		msg.setStatus(HttpStatus.ACCEPTED);
		assertEquals( HttpStatus.ACCEPTED, msg.getStatus());
	}
}
