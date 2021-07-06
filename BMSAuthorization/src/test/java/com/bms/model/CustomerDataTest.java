
package com.bms.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CustomerDataTest {

	CustomerData auth = new CustomerData();
	CustomerData auth1 = new CustomerData("ramesh", "ramesh@792", "token");

	@Test
	void testUsername() {
		auth.setUsername("ramesh");
		assertEquals( "ramesh", auth.getUsername());
	}

	@Test
	void testName() {
		auth.setPassword("Name");
		assertEquals( "Name", auth.getPassword());
	}

	
	@Test
	void testToken() {
		auth.setAuthToken("ad");
		assertEquals("ad", auth.getAuthToken());
	}
	
	@Test
	void testToString() {
		String string = auth1.toString();
		assertEquals(auth1.toString(),string);
	}

}
