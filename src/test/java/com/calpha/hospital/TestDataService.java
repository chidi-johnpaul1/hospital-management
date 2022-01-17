package com.calpha.hospital;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.calpha.hospital.model.Users;
import com.calpha.hospital.repository.UserRepository;

@Service
public class TestDataService {

	private final UserRepository userRepository;
	
	public TestDataService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostConstruct
	@Transactional
	public void createTestUsereData(){
	
	}
	
	
}