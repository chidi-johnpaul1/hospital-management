package com.calpha.hospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.calpha.hospital.model.Users;
import com.calpha.hospital.model.UserAdapter;
import com.calpha.hospital.repository.UserRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User with %s doesn't exist!", username));
		}
		return new UserAdapter(user);
	}

	public Users saveUser(Users user) {
		return userRepository.save(user);
	}
}
