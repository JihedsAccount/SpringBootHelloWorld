package com.javainuse.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.javainuse.controllers.EmployeeController;
import com.javainuse.model.Employee;
import com.javainuse.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmployeeRepository employeeRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetEmployeeByName() {
		Employee u = new Employee();
		u.setEmpId(Long.valueOf(1));

		when(employeeRepository.findByName("name")).thenReturn(u);

		employeeRepository.findByName("name");

		verify(employeeRepository, times(1)).findByName("name");

		Employee user = employeeController.get();

		verify(employeeRepository).findByName("name");

		assertEquals(Long.valueOf(1), user.getEmpId());
	}

	@Test(expected = RuntimeException.class)
	public void testGetEmployeeByNameException() {

		when(employeeRepository.findByName("1l")).thenThrow(new RuntimeException());

		employeeRepository.findByName("1l");

	}
}
