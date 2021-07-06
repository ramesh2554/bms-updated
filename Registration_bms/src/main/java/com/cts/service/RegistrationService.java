package com.cts.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.model.RegistrationDetails;
import com.cts.model.UpdateRegistrationDetails;

@Service
public interface RegistrationService {
	
	public ResponseEntity<Object> register(RegistrationDetails details); 
	public ResponseEntity<Object> editDetails(String token, UpdateRegistrationDetails details,String cid);

}
