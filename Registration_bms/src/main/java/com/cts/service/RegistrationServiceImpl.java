package com.cts.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.dao.RegistrationRepo;
import com.cts.model.CitizenStatus;
import com.cts.model.RegistrationDetails;
import com.cts.model.ResponseMessage;
import com.cts.model.UpdateRegistrationDetails;
import com.cts.restclients.AuthFeign;
import com.cts.utility.Utility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationRepo registrationRepo;

	@Autowired
	private AuthFeign authFeign;

	@Override

	public ResponseEntity<Object> register(RegistrationDetails details) {
		try {

			String uuid = UUID.randomUUID().toString();

			Optional<RegistrationDetails> user = registrationRepo.findByUsername(details.getUsername());

			log.info("Start");
			log.info("Checking for user present  or not " + uuid);

			if (user.isPresent()) {
				log.error("User is Present", details.getUsername());
				return new ResponseEntity<>(
						new ResponseMessage("User already exists", LocalDateTime.now(), HttpStatus.CONFLICT),
						HttpStatus.CONFLICT);
			} else {
				if (!Utility.passwordRegex(details.getPassword())) {
					return new ResponseEntity<>(new ResponseMessage("Password is not in correct format.",
							LocalDateTime.now(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
				}
				log.info("Setting Customer_id");

				details.setCustomer_id("R-" + Math.round(Math.random() * (999 - 100) + 100));
				int age = Utility.getAge(details.getDob());
				log.info("setCitizenStatus based on age");

				if (age < 18) {
					details.setCitizenStatus(CitizenStatus.MINOR.name());
				} else if (age <= 60) {
					details.setCitizenStatus(CitizenStatus.NORMAL.name());
				} else if (age <= 96) {
					details.setCitizenStatus(CitizenStatus.SENIOR.name());
				} else {
					return new ResponseEntity<>(new ResponseMessage("Age should be less than 96 to open account.",
							LocalDateTime.now(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
				}

				if (details.getAccountType().equalsIgnoreCase("Savings")) {
					if (details.getInitialDepositAmount() < 5000)
						return new ResponseEntity<>(new ResponseMessage(
								"For savings Account Inital Deposit amount should be greater than or equal to 5000",
								LocalDateTime.now(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
				} else {
					if (details.getInitialDepositAmount() < 0) {
						return new ResponseEntity<>(new ResponseMessage(
								"For Salary Account Inital Deposit amount should be greater than or equal 0",
								LocalDateTime.now(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
					}
				}

				details.setRegistrationDate(LocalDate.now());

				details.setAccountNumber(Utility.generateAccountNum());

				details.setPassword(Base64.getEncoder().encodeToString(details.getPassword().getBytes()));
				RegistrationDetails save = registrationRepo.save(details);
				save.setPassword("************");
				log.info("User Registered Successfully", uuid);
				log.info("End");
				return new ResponseEntity<>(save, HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error(e.toString());
			return new ResponseEntity<>(
					new ResponseMessage(e.getLocalizedMessage(), LocalDateTime.now(), HttpStatus.PARTIAL_CONTENT),
					HttpStatus.PARTIAL_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Object> editDetails(String token, UpdateRegistrationDetails details, String cid) {

		log.info("Check for validity token ");
		if (authFeign.getValidity(token).getBody().isValid()) {

			Optional<RegistrationDetails> findById = registrationRepo.findById(cid);
			log.info("Check for Customer_id");
			if (findById.isPresent()) {
				RegistrationDetails registrationDetailsExisting = findById.get();

				registrationDetailsExisting.setCustomer_id(cid);

				int age = Utility.getAge(details.getDob());
				if (age < 18) {
					registrationDetailsExisting.setCitizenStatus(CitizenStatus.MINOR.name());
				} else if (age <= 60) {
					registrationDetailsExisting.setCitizenStatus(CitizenStatus.NORMAL.name());
				} else if (age <= 96) {
					registrationDetailsExisting.setCitizenStatus(CitizenStatus.SENIOR.name());
				} else {
					return new ResponseEntity<>(new ResponseMessage("Age should be less than 96 to open account.",
							LocalDateTime.now(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
				}

				registrationDetailsExisting.setName(details.getName());
				registrationDetailsExisting.setCountry(details.getCountry());
				registrationDetailsExisting.setState(details.getState());
				registrationDetailsExisting.setGender(details.getGender());
				registrationDetailsExisting.setBankName(details.getBankName());
				registrationDetailsExisting.setBranchName(details.getBranchName());
				registrationDetailsExisting.setIdentificationDocumentNo(details.getIdentificationDocumentNo());
				registrationDetailsExisting.setIdentificationProofType(details.getIdentificationProofType());
				registrationDetailsExisting.setReferenceAccountHolderName(details.getReferenceAccountHolderName());
				registrationDetailsExisting
						.setReferenceAccountHolderAccountNo(details.getReferenceAccountHolderAccountNo());
				registrationDetailsExisting.setReferenceAccountHolderName(details.getReferenceAccountHolderName());
				registrationDetailsExisting.setAddress(details.getAddress());
				registrationDetailsExisting.setContactNumber(details.getContactNumber());
				registrationDetailsExisting.setEmailAddress(details.getEmailAddress());
				registrationDetailsExisting.setMaritalStatus(details.getMaritalStatus());
				registrationDetailsExisting.setAccountType(details.getAccountType());
				registrationDetailsExisting.setCitizenship(details.getCitizenship());
				registrationDetailsExisting.setGuardianType(details.getGuardianType());
				registrationDetailsExisting.setGuardianName(details.getGuardianName());

				RegistrationDetails save = registrationRepo.save(registrationDetailsExisting);
				save.setPassword("************");
				log.info("User details updated successfully");
				return new ResponseEntity<>(save, HttpStatus.OK);
			} else {
				log.error("Customer id Not Found");
				return new ResponseEntity<>(
						new ResponseMessage("Customer id Not Found", LocalDateTime.now(), HttpStatus.NOT_FOUND),
						HttpStatus.NOT_FOUND);
			}
		} else {
			log.error("Unautherized access");
			return new ResponseEntity<>(new ResponseMessage("Access Denied ,  UNAUTHORIZED", LocalDateTime.now(),
					HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
		}
	}
}
