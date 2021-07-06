package com.bms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.bms.dao.UserDAO;
import com.bms.model.RegistrationDetails;

@SpringBootTest
class CustomerDetailsServiceTest {

	UserDetails userdetails;

	@InjectMocks
	CustomerDetailsService custdetailservice;

	@Mock
	UserDAO userservice;

	@InjectMocks
	JwtUtil jwtUtil;
	
	@Test
	void loadUserByUsernameTest() {

		RegistrationDetails registrationDetails = new RegistrationDetails("ramesh12", "rameswara123");
		Optional<RegistrationDetails> optional = Optional.of(registrationDetails);
		when(userservice.findByUsername("ramesh12")).thenReturn(optional);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(registrationDetails.getUsername());
		assertEquals(registrationDetails.getUsername(), loadUserByUsername.getUsername());
	}
	
	
	@Test
	void loadUserByUsernameFalseTest() {

		RegistrationDetails registrationDetails = new RegistrationDetails("ramesh12", "rameswara123");
		Optional<RegistrationDetails> optional = Optional.of(registrationDetails);
		when(userservice.findByUsername("ramesh12")).thenReturn(optional);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(registrationDetails.getUsername());
		assertNotEquals(registrationDetails.getUsername()+"false", loadUserByUsername.getUsername());
	}
	
	@Test
	 void generateTokenTest() {
		userdetails = new User("ramesh12", "rameswara123", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		assertNotNull(generateToken);
	}
	
	
	@Test
	void loadUserByUsernameIsPresent() {

		RegistrationDetails registrationDetails = new RegistrationDetails("ramesh12", "rameswara123");
		Optional<RegistrationDetails> optional = Optional.of(registrationDetails);
		when(userservice.findByUsername("ramesh12")).thenReturn(optional);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(registrationDetails.getUsername());
		assertEquals(registrationDetails.getUsername(), loadUserByUsername.getUsername());
	}
	
	
}
