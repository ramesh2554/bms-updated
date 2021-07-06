package com.cts.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cts.model.RegistrationDetails;

@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationDetails, String> {
	public Optional<RegistrationDetails> findByUsername(String uname);
}
