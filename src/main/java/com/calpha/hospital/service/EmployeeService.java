package com.calpha.hospital.service;

import java.util.List;


import com.calpha.hospital.model.Employee;
import com.calpha.hospital.model.Patient;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.calpha.hospital.exception.RecordNotFoundException;
import com.calpha.hospital.model.Employee;
import com.calpha.hospital.repository.EmployeeRepository;
 
@Service
public interface EmployeeService {

	  public  List <Employee> getAllEmployees(int pageNo, int pageSize, String sortBy);
	  public  void saveEmployee(Employee employee);
	  public  Employee getEmployeeById(long id);
	  Optional<Employee> findByUserame(String username);
	  public  void deleteEmployeeById(long id);
	  public Employee createOrUpdateEmployee(Employee employee);

/**
	     
	    @Autowired
	    EmployeeRepository repository;
	     
	    public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
	    {
	        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
	 
	        Page<Employee> pagedResult = repository.findAll(paging);
	         
	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Employee>();
	        }
	    }
	     
	    public Employee getEmployeeById(Long id) throws RecordNotFoundException
	    {
	        Optional<Employee> employee = repository.findById(id);
	         
	        if(employee.isPresent()) {
	            return employee.get();
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    }
	     
	    public Employee createOrUpdateEmployee(Employee entity) throws RecordNotFoundException
	    {
	        Optional<Employee> employee = repository.findById(entity.getEmployeeId());
	         
	        if(employee.isPresent())
	        {
	            Employee newEntity = employee.get();
	            newEntity.setEmail(entity.getEmail());
	            newEntity.setFirstname(entity.getFirstname());
	            newEntity.setLastname(entity.getLastname());
	 
	            newEntity = repository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = repository.save(entity);
	             
	            return entity;
	        }
	    }
	     
	    public void deleteEmployeeById(Long id) throws RecordNotFoundException
	    {
	        Optional<Employee> employee = repository.findById(id);
	         
	        if(employee.isPresent())
	        {
	            repository.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    }
	    **/
	}


