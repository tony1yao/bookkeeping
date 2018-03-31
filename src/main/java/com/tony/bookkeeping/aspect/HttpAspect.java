package com.tony.bookkeeping.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {
	
	@Before("execution(public * com.tony.bookkeeping.controller.UserController.*(..))")
	public void log()
	{
		System.out.println("1111111");
	}
}
