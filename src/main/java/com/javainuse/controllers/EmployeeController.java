package com.javainuse.controllers;

import javax.validation.constraints.NotNull;

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
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employee/{name}", method = RequestMethod.GET)
	public Employee findEmployee(@PathVariable @NotNull String name) {

		logger.info("Execute findEmployee endpoint..");
		logger.debug("Debug test....");
		logger.error("Error test....");
		
		Employee employee = employeeService.findByName(name);

		return employee;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Employee get() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId(Long.valueOf(1));
		emp.setSalary(3000);

		return emp;
	}
	
	@RequestMapping(value = "/saveemployee", method = RequestMethod.POST)
	public Employee saveEmployee(Employee employee) {

		employee = employeeService.save(employee);
		return employee;
	}

}
