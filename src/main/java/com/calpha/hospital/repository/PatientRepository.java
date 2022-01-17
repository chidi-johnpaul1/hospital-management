package com.calpha.hospital.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.calpha.hospital.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	Optional<Patient> findByEmail(@Param("email") String email);

   // Optional<Patient> findByUsername(@Param("name") String name);
	
	@Query("SELECT t FROM Patient t WHERE " +
            "LOWER(t.lastName) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.firstName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    Page<Patient> searchByTerm(@Param("searchTerm") String searchTerm, Pageable pageable);
}
