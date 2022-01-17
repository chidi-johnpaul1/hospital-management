package com.calpha.hospital.repository;

import com.calpha.hospital.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Role findByRole(@Param("role") String role);
    
	Role findByName(String name);

    @Override
    void delete(Role role);
}