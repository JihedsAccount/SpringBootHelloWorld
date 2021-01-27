package com.javainuse.service;

import java.util.List;

import com.javainuse.model.Employee;

public interface EmployeeService {

	public Employee findByName(String name);
	
	public Employee save(Employee employee);
	
	
	public Employee saveEmployee(Employee employee);
	public Employee deleteEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Employee findByIdEmployee(Long empId);
	public List<Employee> findAll();
}
