package com.javainuse.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.model.Employee;
import com.javainuse.repository.EmployeeDataBaseRepository;
import com.javainuse.repository.EmployeeRepository;
import com.javainuse.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeDataBaseRepository employeeDataBaseRepository;

	@Override
	public Employee findByName(String name) {

		return employeeRepository.findByName(name);
	}

	@Override
	public Employee save(Employee employee) {

		return employeeRepository.save(employee);
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	
	

	@Override
	public List<Employee> findAll() {

		return (List<Employee>) employeeDataBaseRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeDataBaseRepository.save(employee);
	}

	@Override
	public Employee deleteEmployee(Employee employee) {
		
		employeeDataBaseRepository.delete(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeDataBaseRepository.save(employee);
	}

	@Override
	public Employee findByIdEmployee(Long empId) {
		/**
		 * https://www.callicoder.com/java-8-optional-tutorial/
		 */
		
		Optional<Employee> o = employeeDataBaseRepository.findById(empId);
		/**
		 * 
		 */
		o.ifPresent(e -> {
			System.out.println(e);
		});
		/**
		 * 
		 */
		
		return employeeDataBaseRepository.findById(empId).orElseThrow(RuntimeException::new);
//		or
//		return employeeDataBaseRepository.findById(empId).orElseThrow(() -> {
//			new RuntimeException("Employee not found...");
//		});
		/**
		 * 
		 */
		 
//		return Optional.ofNullable(o.get()).orElseThrow(RuntimeException::new);
		
//		o.map((x) -> {
//	        return x;
//	    }).orElseThrow(RuntimeException::new);
		
		
	}

}
