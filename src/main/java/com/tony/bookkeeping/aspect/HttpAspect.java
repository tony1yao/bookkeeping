package com.tony.bookkeeping.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.tony.bookkeeping.controller.UserController.*(..))")
	public void log()
	{
	}
	
	@Before("log()")
	public void before(JoinPoint jointPoint)
	{
		ServletRequestAttributes servletRequest = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request= servletRequest.getRequest();
		//url
		logger.info("url = {}", request.getRequestURL());
		//HTTP method
		logger.info("HTTP method = {}", request.getMethod());
		
		//ip
		logger.info("ip={}", request.getRemoteAddr());

		//class.method
		logger.info("class.method = {}", jointPoint.getSignature().getDeclaringTypeName()+"."+jointPoint.getSignature().getName());
		
		//args
		logger.info("arguments = {}", jointPoint.getArgs());
	}
	
	
	@After("log()")
	public void after()
	{
		logger.info("inside of after()");
	}
	
	@AfterReturning(returning = "object", pointcut = "log()")
	public void getReturnContent(Object object)
	{
		logger.info("returning object = {}", object);
	}
}
