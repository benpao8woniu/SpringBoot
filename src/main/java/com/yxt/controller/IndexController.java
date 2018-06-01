package com.yxt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxt.entity.Student;
import com.yxt.service.StudentService;

@Controller
@RequestMapping("/freemarker")
public class IndexController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping("/index")
	public String index(Map<String, Object> map){
		map.put("name", "zhangsan");
		map.put("sex", 1);
		List<String> list = new ArrayList<>();
		list.add("³Ô");
		list.add("ºÈ");
		list.add("Íæ");
		list.add("ÀÖ");
		map.put("list", list);
		return "freemarker/index";
	}
	
	
	@RequestMapping("/update")
	public @ResponseBody String updateStudent(String name,int id){
		
		studentService.updateStudent(name, id);
		return "success";
	}
	
	@RequestMapping("/fetch")
	public @ResponseBody Student fetchStudent(int id){
		
		return studentService.fetchStudent(id);
	}
	
	@RequestMapping("/fetch1")
	public @ResponseBody Student fetchStudent1(int id){
		
		return studentService.fetchstudentMapper(id);
	}
	
	@RequestMapping("/fetch2")
	public @ResponseBody Student fetchstudentMapperTest1(int id){
		
		return studentService.fetchstudentMapperTest1(id);
	}
	
	@RequestMapping("/fetch3")
	public @ResponseBody Student fetchstudentMapperTest2(int id){
		
		return studentService.fetchstudentMapperTest2(id);
	}
}
