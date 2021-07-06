package com.bms.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;


@SpringBootTest
 class MessageResponseTest {
	
	MessageResponse msg = new MessageResponse();
	MessageResponse msg1 = new MessageResponse("error",LocalDateTime.now(), HttpStatus.ACCEPTED);
	
	@Test
	void testMsg() {
		msg.setMessage("Error Occured");
		assertEquals( "Error Occured", msg.getMessage());
	}


	
	@Test
	void testDate() {
		LocalDateTime date = LocalDateTime.now(); 
		msg.setDate(date);
		assertEquals( date, msg.getDate());
	}
	@Test
	void testStatusCode() {
		 
		msg.setStatus(HttpStatus.ACCEPTED);
		assertEquals( HttpStatus.ACCEPTED, msg.getStatus());
	}
	
	
	
	

}
