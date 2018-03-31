package com.tony.bookkeeping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@RequestMapping(value="/hello/{id}", method=RequestMethod.GET)
	public String say(@PathVariable("id") Integer id)
	{
		return "id is:"+id;
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello()
	{
		return "Hello";
	}
	
	@GetMapping(value="/compain")
	public String complain()
	{
		return "compain ";
	}
	
	
	@GetMapping(value="/say")
	public String getParameterValue(@RequestParam("id") Integer myId)
	{
		return "Hello : "+myId;
	}
}
