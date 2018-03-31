package com.tony.bookkeeping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping(value = "/adduser")
	public User addUser(@RequestParam("name") String name, @RequestParam("gender") String gender,@RequestParam("birthday") String birthday,@RequestParam("profession") String profession)
	{
		User user = new User();
		user.setBirthday(birthday);
		user.setGender(gender);
		user.setName(name);
		user.setProfession(profession);
		return userRepository.save(user);
	}
}
