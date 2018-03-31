package com.tony.bookkeeping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value="/user/{id}")
	public User getUser(@PathVariable("id") Integer id)
	{
		return userRepository.findById(id).get();
	}
	
	
	@PutMapping(value="/user/{id}")
	public User updateUser(@PathVariable("id") Integer id,@RequestParam("name") String name, @RequestParam("gender") String gender,@RequestParam("birthday") String birthday,@RequestParam("profession") String profession)
	{
		User user = new User();
		user.setId(id);
		user.setBirthday(birthday);
		user.setGender(gender);
		user.setName(name);
		user.setProfession(profession);
		return userRepository.save(user);
	}
	
	@DeleteMapping(value="/user/{id}")
	public void deleteUser(@PathVariable("id") Integer id)
	{
		userRepository.deleteById(id);
	}
	
	@GetMapping(value="/user/gender/{gender}")
	public List<User> getUserByGender(@PathVariable("gender") String gender)
	{
		return userRepository.findByGender(gender);
	}
}
