package com.tony.bookkeeping.exception;

import com.tony.bookkeeping.beans.ExceptionEnum;

public class UserException extends RuntimeException {

	private Integer code;
	
	public UserException(ExceptionEnum exception)
	{
		super(exception.getMessage());
		code = exception.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
