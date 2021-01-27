package com.javainuse.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;

@RestController
public class EmployeeDataBaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDataBaseController.class);
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Employee> findAll() {

		logger.info("recherche des employés à partir de la base des données .. endpoint...");
		List<Employee> employees = employeeService.findAll();

		return employees;
	}
	
	@RequestMapping(value = "/findById/{empId}", method = RequestMethod.GET)
	public Employee findById(@PathVariable long empId) {

		logger.info("recherche d'un employé par ID à partir de la base des données .. endpoint...");
		Employee employee = employeeService.findByIdEmployee(Long.valueOf(empId));

		return employee;
	}
	
	

}
