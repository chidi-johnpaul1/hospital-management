package com.calpha.hospital.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import com.calpha.hospital.model.Employee;
import com.calpha.hospital.repository.EmployeeRepository;
import com.calpha.hospital.service.EmployeeService;


public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
    private EmployeeRepository emloyeeRepository;

    public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
        return emloyeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        this.emloyeeRepository.save(employee);
    }
    
    public Employee getEmployeeById(long id) {
        
    	Optional <Employee> optional = emloyeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
        	employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    public void deleteEmployeeById(long id) {
        this.emloyeeRepository.deleteById(id);
    }

	@Override
	public List<Employee> getAllEmployees(int pageNo, int pageSize, String sortBy) {
		 List<Employee> employee = new ArrayList<Employee>();
		 Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		 
	        Page<Employee> pagedResult = emloyeeRepository.findAll(paging);
	         
	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return employee;
	        }
	}

	@Override
	public Employee createOrUpdateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findByUserame(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
