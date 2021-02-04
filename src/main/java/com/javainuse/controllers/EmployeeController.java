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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="EmployeeController", description="Employees Management REST APIs")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "View an employee by its name", response = Employee.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved employee"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/employee/{name}", method = RequestMethod.GET, produces = "application/json")
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
