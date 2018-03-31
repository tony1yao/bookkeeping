package com.tony.bookkeeping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tony.bookkeeping.beans.User;
import com.tony.bookkeeping.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/users")
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}
}
