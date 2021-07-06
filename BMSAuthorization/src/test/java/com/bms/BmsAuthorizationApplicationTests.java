package com.bms;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BmsAuthorizationApplicationTests {

	@Test
	void contextLoads() {
		BmsAuthorizationApplication.main(new String[] {});
		assertTrue(true);
	}

}
