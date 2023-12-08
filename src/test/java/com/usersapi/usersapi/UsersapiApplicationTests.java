package com.usersapi.usersapi;

import com.usersapi.usersapi.Models.User;
import com.usersapi.usersapi.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;

class UsersapiApplicationTests extends AbstractSetUp{

	@Test
	void contextLoads() {
	}

	@Override
	@BeforeEach
	public void setUp(){
		super.setUp();
	}

	@MockBean
	private UsersService usersservice;

	@Test
	public void getUsersList() throws Exception{
		String uri = "/users";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
						.get(uri)
						.accept(MediaType.APPLICATION_JSON))
						.andReturn();

		int status = mvcResult.getResponse().getStatus();

		assertEquals(200, status);
	}

	@Test
	public void createCustomer() throws Exception{
		String uri = "/users";
		User newUser = new User();
		newUser.setId(29);
		newUser.setAge(20);
		newUser.setEmail("LautaroMartinez@gmail.com");
		newUser.setName("Lautaro Martinez");

		String inputJson = super.mapToJson(newUser);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
	}
}


