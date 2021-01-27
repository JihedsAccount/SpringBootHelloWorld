package com.javainuse.test.db;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.javainuse.test.SpringBootHelloWorldTests;

public class TestWebDatabaseApp extends SpringBootHelloWorldTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testFindAll() throws Exception {

		String uri = "/findAll";

		mockMvc.perform(get(uri)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$[0].name").value("name"))
				.andExpect(jsonPath("$[0].designation").value("designation"))
				.andExpect(jsonPath("$[0].empId").value(1))
				.andExpect(jsonPath("$[0].salary").value(2000));

	}
	
	@Test
	public void findByIdEmployee() throws Exception {

		String uri = "/findById/1";

		mockMvc.perform(get(uri)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("name"))
				.andExpect(jsonPath("$.designation").value("designation"))
				.andExpect(jsonPath("$.empId").value(1))
				.andExpect(jsonPath("$.salary").value(2000));

	}
	
	@Test(expected = Exception.class)
	public void findByIdEmployeeException() throws Exception {

		String uri = "/findById/2";

		mockMvc.perform(get(uri)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("name"))
				.andExpect(jsonPath("$.designation").value("designation"))
				.andExpect(jsonPath("$.empId").value(1))
				.andExpect(jsonPath("$.salary").value(2000));

	}
	

}
