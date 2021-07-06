package com.bms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.model.RegistrationDetails;

@Repository
public interface UserDAO extends JpaRepository<RegistrationDetails, String> {
	public Optional<RegistrationDetails> findByUsername(String uname);
}
