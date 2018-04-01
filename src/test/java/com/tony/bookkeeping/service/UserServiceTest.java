package com.tony.bookkeeping.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tony.bookkeeping.beans.User;

import junit.framework.TestCase;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testAddUser() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetUsers() {
		User user = userService.getUser(0);
		TestCase.assertEquals("Tony", user.getName());
	}

	@Test
	public void testGetUser() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetUserByGender() {
		//fail("Not yet implemented");
	}

}
