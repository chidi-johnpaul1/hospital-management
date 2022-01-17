package com.calpha.hospital.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.calpha.hospital.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(@Param("email") String email);

    Optional<Users> findByUsername(@Param("username") String username);
    Iterable<Users> findByActive(@Param("active") boolean active);
    
    List<Users> findByFirstNameIgnoreCaseContaining(String firstName);

    List<Users> findByLastNameIgnoreCaseContaining(String lastName);

    List<Users> findByEmailIgnoreCaseContaining(String email);
    
    @Query("SELECT t FROM Users t WHERE " +
            "LOWER(t.lastName) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.firstName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    Page<Users> searchByTerm(@Param("searchTerm") String searchTerm, Pageable pageable);

	Page<Users> findAll(Pageable pageable);
	
	@Override
    void delete(Users user);
}
