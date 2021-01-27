package com.javainuse.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.javainuse.model.Employee;
import com.javainuse.test.util.TestUtil;

public class TestWebApp extends SpringBootHelloWorldTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetEmployeeByName() throws Exception {
		
		String uri = "/employee".concat("/jihed");
		
		mockMvc.perform(get(uri)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("name"))
				.andExpect(jsonPath("$.designation").value("designation"))
				.andExpect(jsonPath("$.empId").value("5"))
				.andExpect(jsonPath("$.salary").value(2000));

	}
	
	@Test
	@Ignore
	public void testCreateEmployee() throws Exception {
		String uri = "/saveemployee";

		Employee employee = new Employee(null, "name", "designation", 2500);

		mockMvc.perform( MockMvcRequestBuilders
			      .post(uri)
			      .content(TestUtil.mapToJson(employee))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());

	}
	

}
