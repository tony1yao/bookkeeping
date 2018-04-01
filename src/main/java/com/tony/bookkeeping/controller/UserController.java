package com.tony.bookkeeping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tony.bookkeeping.beans.Result;
import com.tony.bookkeeping.beans.User;
import com.tony.bookkeeping.exception.UserException;
import com.tony.bookkeeping.repository.UserRepository;
import com.tony.bookkeeping.service.UserService;
import com.tony.bookkeeping.util.ResultUtil;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value = "/users")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	@PostMapping(value = "/adduser")
	public Result<User> addUser(User user , BindingResult result)
	{
		if(result.hasErrors())
		{
			logger.info("Error happened.");
			return ResultUtil.error(0, result.getFieldError().getDefaultMessage());
		}
		return userService.addUser(user);
	}
	
	@GetMapping(value="/user/{id}")
	public User getUser(@PathVariable("id") Integer id)
	{
		return userService.getUser(id);
	}
	
	
	@PutMapping(value="/user/{id}")
	public Result<User> updateUser(User user)
	{
		return userService.updateUser(user);
	}
	
	@DeleteMapping(value="/user/{id}")
	public void deleteUser(@PathVariable("id") Integer id)
	{
		userService.deleteUser(id);
	}
	
	@GetMapping(value="/user/gender/{gender}")
	public List<User> getUserByGender(@PathVariable("gender") String gender) throws UserException
	{
		return userService.getUserByGender(gender);
	}
}
