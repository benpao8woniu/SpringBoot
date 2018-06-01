package com.yxt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@RequestMapping("/student")
	public String student(HttpServletRequest request) {
		int i=1/0;
		return "уехЩ";
	}

}
