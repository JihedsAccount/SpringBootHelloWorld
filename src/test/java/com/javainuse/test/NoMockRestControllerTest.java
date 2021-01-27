package com.javainuse.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.javainuse.model.Employee;
import com.javainuse.test.util.TestUtil;

/**
 * https://www.tutorialspoint.com/spring_boot/spring_boot_rest_controller_unit_test.htm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoMockRestControllerTest {

	protected MockMvc mvc;
	@Autowired
	protected WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetEmployeeByName() throws Exception {

		String uri = "/employee".concat("/jihed");

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Employee employee = TestUtil.mapFromJson(content, Employee.class);
		assertNotNull(employee);
		assertTrue(employee.getEmpId() == 5);
	}

	@Test
	@Ignore
	public void testCreateEmployee() throws Exception {
		String uri = "/saveemployee";

		Employee employee = new Employee(null, "name", "designation", 2500);

		String inputJson = TestUtil.mapToJson(employee);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		Employee savedEmployee = TestUtil.mapFromJson(content, Employee.class);

		assertTrue(savedEmployee.getName().equals("name"));
	}

	

}
