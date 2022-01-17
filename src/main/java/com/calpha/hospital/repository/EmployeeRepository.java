package com.calpha.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.calpha.hospital.model.Employee;


	@Repository
	public interface EmployeeRepository extends JpaRepository<Employee, Long> {


		Optional<Employee> findByEmail(@Param("email") String email);

	    Optional<Employee> findByPhoneNo(@Param("phoneNo") String phoneNo);
	    
	    //Optional<Employee> findByUsername(@Param("username") String username);
}
	
