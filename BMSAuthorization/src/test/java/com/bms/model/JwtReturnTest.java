package com.bms.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtReturnTest {

	Jwtreturn jwt=new Jwtreturn("token");
	@Test
	void testToken() {
		assertEquals( "token", jwt.getJwt());
	}
}
