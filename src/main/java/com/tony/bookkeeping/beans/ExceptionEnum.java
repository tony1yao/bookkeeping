package com.tony.bookkeeping.beans;

public enum ExceptionEnum {
	
	UNKNOWN_ERROR(-1,"Unknown errors"),
	SUCCESS(1,"Operation is done successfully")
	;
	private Integer code;
	private String message;
	private ExceptionEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
	
}
