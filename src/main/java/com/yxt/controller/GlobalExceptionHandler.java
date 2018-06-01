package com.yxt.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//捕获全局异常类
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String exceptionMessages(Throwable trowable) {

		StringBuilder sb = new StringBuilder();
		sb.append(trowable.toString() + "\n");

		StackTraceElement[] stack = trowable.getStackTrace();
		for (int i = 0; i < stack.length; i++) {

			sb.append(trowable.getStackTrace()[i].toString());
		}

		return sb.toString();
	}

}
