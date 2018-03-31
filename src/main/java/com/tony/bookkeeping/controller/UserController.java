package com.tony.bookkeeping.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public User addUser(User user)
	{
		user.setBirthday(user.getBirthday());
		user.setGender(user.getGender());
		user.setName(user.getName());
		user.setProfession(user.getProfession());
		return userRepository.save(user);
	}
	
	@GetMapping(value="/user/{id}")
	public User getUser(@PathVariable("id") Integer id)
	{
		return userRepository.findById(id).get();
	}
	
	
	@PutMapping(value="/user/{id}")
	public User updateUser(User user)
	{
		user.setId(user.getId());
		return addUser(user);
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
