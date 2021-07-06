package com.bms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.bms.dao.UserDAO;
import com.bms.model.AuthResponse;
import com.bms.model.CustomerData;
import com.bms.service.CustomerDetailsService;
import com.bms.service.JwtUtil;

@SpringBootTest
class AuthControllerTest {

	@InjectMocks
	AuthController authController;

	AuthResponse authResponse;

	UserDetails userdetails;

	@Mock
	JwtUtil jwtutil;

	@Mock
	CustomerDetailsService custdetailservice;

	@Mock
	UserDAO userservice;

	@Test
	 void loginTest() {

		CustomerData user = new CustomerData("ramesh12", "rameswara123", null);
		
		String decode = new String(Base64.getDecoder().decode(user.getPassword()));
		
		CustomerData user1 = new CustomerData("ramesh12", decode , null);
		
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(user.getUsername());
		UserDetails value = new User(user.getUsername(), decode, new ArrayList<>());
		when(custdetailservice.loadUserByUsername(user.getUsername())).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(user1);
		assertEquals( 200, login.getStatusCodeValue());
	}

	@Test
	 void loginTestFailed() {

		CustomerData user = new CustomerData("ramesh12", "rameswara123", null);
		String decode = new String(Base64.getDecoder().decode(user.getPassword()));
		CustomerData user1 = new CustomerData("ramesh12", decode , null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(user.getUsername());
		UserDetails value = new User(user.getUsername(), decode+"w", new ArrayList<>());
		when(custdetailservice.loadUserByUsername(user.getUsername())).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(user1);
		assertEquals( 403, login.getStatusCodeValue());
	}

	@Test
	 void validateTestValidtoken() {

		
		
		when(jwtutil.extractUsername("token")).thenReturn("ramesh12");
		when(jwtutil.validateToken("token")).thenReturn(true);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals( true, validity.getBody().toString().contains("true"));
		
	}

	@Test
	 void validateTestInValidtoken() {

		when(jwtutil.validateToken("token")).thenReturn(false);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals( true, validity.getBody().toString().contains("false"));
	}


}
