package com.javainuse.repository;

import com.javainuse.model.Employee;

public interface EmployeeRepository {
	
	public Employee findByName(String name);
	
	public Employee save(Employee employee);

}
