package com.tony.bookkeeping.util;

import com.tony.bookkeeping.beans.Result;

public class ResultUtil {

	public static Result success(Object data)
	{
		Result result = new Result();
		result.setCode(1);
		result.setMessage("Success");
		result.setResponseData(data);
		return result;
	}
	
	public static Result success()
	{
		return success(null);
	}
	
	public static Result error(Integer code, String message)
	{
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		return result;
	}
}
