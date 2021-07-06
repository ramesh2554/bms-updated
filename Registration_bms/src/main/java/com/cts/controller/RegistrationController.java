package com.cts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.RegistrationDetails;
import com.cts.model.UpdateRegistrationDetails;
import com.cts.service.RegistrationServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class RegistrationController {

	@Autowired
	RegistrationServiceImpl registrationService;

	/*
	 * { "name": "ramesh", "username": "kkkkkkkkk", "password": "rameswara",
	 * "guardianType": "father", "guardianName": "Ramesh", "address":
	 * "1-57,Madhavaram", "citizenship": "Indian", "state": "andhra", "country":
	 * "India", "emailAddress": "temp@gmail.com", "gender": "male", "maritalStatus":
	 * "un married", "contactNumber": "9493430753", "dob":
	 * "2020-01-02T00:00:00.000+00:00", "identificationProofType": "PAN",
	 * "identificationDocumentNo": "JCUPK3434A", "referenceAccountHolderName":
	 * "ramesh", "referenceAccountHolderAccountNo": "12345",
	 * "referenceAccountHolderAddress": "same", "accountType": "Savings",
	 * "bankName": "Indian", "branchName": "JRG main Branch",
	 * "initialDepositAmount": 5000 }
	 */

	// http://localhost:8081/register
	@PostMapping("/register")
	public ResponseEntity<Object> registrationPage(@Valid @RequestBody RegistrationDetails registrationDetails) {
		log.info("Start");
		log.info("RegistrationDetails Started");
		log.info("End");
		return registrationService.register(registrationDetails);

	}

	@PutMapping(value = "/editDetails/{customer_id}")
	public ResponseEntity<Object> editDetails(@RequestHeader("Authorization") String token,
			@RequestBody UpdateRegistrationDetails updateDetails, @PathVariable String customer_id) {
		log.info("Start");

		log.info("RegistrationService Started");
		log.info("End");
		return registrationService.editDetails(token, updateDetails, customer_id);

	}

}
