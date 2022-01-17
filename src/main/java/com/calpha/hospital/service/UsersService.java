package com.calpha.hospital.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.calpha.hospital.model.Users;

public interface UsersService {
	
  public  List <Users> getAllUsers();
  
  public  void saveUser(Users user);
  
  public  Users getUserById(long id);
  
  public Optional<Users> findByEmail(String email);
  
  public Optional<Users> findByUsername(String username);
  
  public Iterable<Users> findByActive(boolean active);
  
  public  void deleteUserById(long id);
  
  Page<Users> searchByTerm(String name, Pageable pageable);

  Page<Users> listUsers(Pageable pageable);

  List<Users> searchBy(String keyword, String criteria);

}
