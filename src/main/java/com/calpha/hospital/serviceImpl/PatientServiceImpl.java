package com.calpha.hospital.serviceImpl;


import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.calpha.hospital.model.Patient;
import com.calpha.hospital.repository.PatientRepository;
import com.calpha.hospital.service.PatientService;

@Transactional
@Repository
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientRepository patientRepository;

	
	@Override
	public Optional<Patient> findByEmail(String email) {
		// TODO Auto-generated method stub
		  return patientRepository.findByEmail(email);
	}


	@Override
	public Page<Patient> searchByTerm(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Patient> listUsers(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> searchBy(String keyword, String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Patient> findPatientByFirstname(String patientName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void savePatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	
}
