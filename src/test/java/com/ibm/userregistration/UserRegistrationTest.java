package com.ibm.userregistration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.userregistration.dto.UserDTO;

public class UserRegistrationTest extends UserregistrationApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private ObjectMapper objectMapper;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void shouldRegiterUser() throws Exception {
		UserDTO userDTO = new UserDTO("James", "Mind_123", "24.48.0.1");
		((ResultActions) ((MockHttpServletRequestBuilder) mockMvc
				.perform(post("/api/userRegistration").contentType("application/json;charset=UTF-8")))
				.content(objectMapper.writeValueAsString(userDTO))).andExpect(status().isOk()).andDo(print());
	}
	
	  @Test
	  void shouldValidatePassword() throws Exception {
		  UserDTO userDTO = new UserDTO("James", "Mind@123", "24.48.0.1");
		  mockMvc.perform(post("/api/userRegistration").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(userDTO)))
	        .andExpect(status().isBadRequest())
	        .andDo(print());
	  }
	  
	  @Test
	  void shouldValidateIPAddress() throws Exception {
		  UserDTO userDTO = new UserDTO("James", "Mind@123", "101.208.0.0");
		  mockMvc.perform(post("/api/userRegistration").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(userDTO)))
	        .andExpect(status().isBadRequest())
	        .andDo(print());
	  }


}
