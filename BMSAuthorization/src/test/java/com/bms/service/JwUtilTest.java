package com.bms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.bms.dao.UserDAO;


@SpringBootTest
 class JwUtilTest {

	@Mock
	UserDetails userdetails;

	@InjectMocks
	JwtUtil jwtUtil;

	@Mock
	JwtUtil jwt;
	
	@Mock
	UserDAO userservice;
	
	@Mock
	CustomerDetailsService customerDetailsService;
	

	@Test
	 void generateTokenTest() {
		userdetails = new User("ramesh12", "rameswara123", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		assertNotNull(generateToken);
	}
	

	@Test
	 void validateTokenTest() {
		userdetails = new User("ramesh12", "rameswara123", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}
	
	@Test
	 void validateTokenNegativeTest() {
		userdetails = new User("ramesh12", "rameswara123", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken+"wrong");
		assertFalse(validateToken);
	}



}
