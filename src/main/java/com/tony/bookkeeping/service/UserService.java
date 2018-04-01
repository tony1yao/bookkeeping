package com.tony.bookkeeping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.bookkeeping.beans.Result;
import com.tony.bookkeeping.beans.ExceptionEnum;
import com.tony.bookkeeping.beans.User;
import com.tony.bookkeeping.exception.UserException;
import com.tony.bookkeeping.repository.UserRepository;
import com.tony.bookkeeping.util.ResultUtil;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	public Result<User> addUser(User user)
	{
		user.setBirthday(user.getBirthday());
		user.setGender(user.getGender());
		user.setName(user.getName());
		user.setProfession(user.getProfession());
		return ResultUtil.success(userRepository.save(user));
	}
	
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}
	
	public User getUser(Integer id)
	{
		return userRepository.findById(id).get();
	}
	
	public Result<User> updateUser(User user)
	{
		user.setId(user.getId());
		return addUser(user);
	}
	
	public void deleteUser(Integer id)
	{
		userRepository.deleteById(id);
	}
	
	public List<User> getUserByGender(String gender) throws UserException
	{
		if(gender.isEmpty())
		{
			throw new UserException(ExceptionEnum.UNKNOWN_ERROR);
		}
		return userRepository.findByGender(gender);
	}
}
