package com.bms.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bms.dao.UserDAO;
import com.bms.exception.UnauthorizedException;
import com.bms.model.RegistrationDetails;

@Service
public class CustomerDetailsService implements UserDetailsService {
	@Autowired
	private UserDAO userdao;

	/**
	 * @param String
	 * @return User
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {

		try {

			Optional<RegistrationDetails> user = userdao.findByUsername(username);
			if (user.isPresent()) {
				// user.get().getUsername();
				String decode = new String(Base64.getDecoder().decode(user.get().getPassword()));
				return new User(user.get().getUsername(), decode, new ArrayList<>());
			} else {
				throw new UnauthorizedException("User id not found");
			}
		} catch (Exception e) {
			throw new UnauthorizedException("Username Not Found");
		}

	}

}
