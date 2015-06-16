package com.kainos.training.login.service.resource;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginResourceTest {
	
	private static final String CORRECT_TEST_USERNAME="test";
	private static final String CORRECT_TEST_PASSWORD="test";
	
	public LoginResource loginResource;
	
	@Before
	public void setup(){
		loginResource = new LoginResource(CORRECT_TEST_USERNAME, CORRECT_TEST_PASSWORD);
	}
	
	@Test
	public void shouldLogin_WithCorrectUsernameAndPassword(){
		Response response = loginResource.login(CORRECT_TEST_USERNAME,CORRECT_TEST_PASSWORD);
		assertThat(response.getStatus(), is(204));
	}
	
	@Test
	public void shouldNotLogin_WithIncorrectUsernameAndPassword(){
		try{
			Response response = loginResource.login("not a username", "not a password");
		} catch (WebApplicationException e) {
			assertThat(e.getResponse().getStatus(), is(401));
		}
	}

}
