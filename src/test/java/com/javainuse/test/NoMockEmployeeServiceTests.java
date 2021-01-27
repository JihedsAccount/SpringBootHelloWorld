package com.javainuse.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoMockEmployeeServiceTests {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testGetEmployeeByName() {

		Employee employee = employeeService.findByName("name");

		assertTrue(employee.getEmpId() == 5);
	}

}
