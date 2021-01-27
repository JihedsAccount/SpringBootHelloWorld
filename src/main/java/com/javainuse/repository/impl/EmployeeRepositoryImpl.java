package com.javainuse.repository.impl;

import org.springframework.stereotype.Repository;

import com.javainuse.model.Employee;
import com.javainuse.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Override
	public Employee findByName(String name) {

		return new Employee(Long.valueOf(5), "name", "designation", 2000);
	}

	@Override
	public Employee save(Employee employee) {
		
//		employee.setEmpId(Long.valueOf(l));
		return employee;
	}
	
	

}
