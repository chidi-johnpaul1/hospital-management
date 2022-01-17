package com.calpha.hospital.service;
import com.calpha.hospital.model.Patient;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

public interface PatientService {


	Optional<Patient> findPatientByFirstname(String patientName);

    Optional<Patient> findByEmail(String email);
    
    Page<Patient> searchByTerm(String name, Pageable pageable);

    Page<Patient> listUsers(Pageable pageable);

    List<Patient> searchBy(String keyword, String criteria);

	void savePatient(Patient patient);
}
    

