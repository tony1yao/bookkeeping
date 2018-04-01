package com.tony.bookkeeping.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tony.bookkeeping.beans.Result;
import com.tony.bookkeeping.exception.UserException;
import com.tony.bookkeeping.util.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
	
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Result handleException(Exception e)
	{
		if(e instanceof UserException)
		{
			UserException exception = (UserException) e;
			return ResultUtil.error(exception.getCode(), exception.getMessage());
		}
		logger.error("System Error, {}",e);
		return ResultUtil.error(100, e.getMessage());
	}
}
