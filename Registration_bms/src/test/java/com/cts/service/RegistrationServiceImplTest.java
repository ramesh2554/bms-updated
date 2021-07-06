package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cts.dao.RegistrationRepo;
import com.cts.model.RegistrationDetails;
import com.cts.model.UpdateRegistrationDetails;
import com.cts.model.ValidateToken;
import com.cts.restclients.AuthFeign;
import com.cts.utility.Utility;

@SpringBootTest
class RegistrationServiceImplTest {

	@InjectMocks
	RegistrationServiceImpl service;

	@Mock
	RegistrationRepo repo;
	
	@Mock
	AuthFeign authFeign;


	@Test
	void registrationUser() throws Exception {

		RegistrationDetails details = new RegistrationDetails();
		details.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("02/01/1999"));
		details.setAccountType("salary");
		details.setUsername("ramesh1234");
		details.setPassword("Rameswara@123");
		boolean regex = Utility.passwordRegex(details.getPassword());
		
		when(repo.findById("R-327")).thenReturn(Optional.ofNullable(null));
		
		when(repo.save(details)).thenReturn(details);
		ResponseEntity<?> response = service.register(details);
		assertEquals(200, response.getStatusCodeValue());
	}
	

	@Test
	void registrationUserFail() throws Exception {

		RegistrationDetails details = new RegistrationDetails();
		details.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("02/01/1999"));
		details.setAccountType("salary");
		details.setUsername("ramesh1234");
		details.setPassword("Rameswara@123");
		when(repo.findById("R-327")).thenReturn(Optional.ofNullable(null));
		when(repo.save(details)).thenReturn(details);
		ResponseEntity<?> response = service.register(details);
		assertNotEquals(209, response.getStatusCodeValue());
	}
	
	@Test
	void updateDetails() throws Exception {
		UpdateRegistrationDetails details = new UpdateRegistrationDetails();
		RegistrationDetails regDetails = new RegistrationDetails();

		details.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("02/01/1999"));
		details.setAccountType("Savings");
		regDetails.setDob(details.getDob());
		regDetails.setAccountType(details.getAccountType());
		ValidateToken tokenValid = new ValidateToken("uid", "name", true);
		ResponseEntity<ValidateToken> response = new ResponseEntity<ValidateToken>(tokenValid, HttpStatus.OK);
		when(authFeign.getValidity("token")).thenReturn(response);
		when(repo.save(regDetails)).thenReturn(regDetails);
		assertEquals(404, service.editDetails("token", details, "R-001").getStatusCodeValue());
	}

}
