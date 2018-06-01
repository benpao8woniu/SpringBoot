package com.yxt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class HelloWorldController {

	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		
		return "success";
	}
	
	@RequestMapping("/getMap")
	public Map<String, Object> getMap(HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		map.put("state", 1);
		return map;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldController.class, args);
	}
	
}
