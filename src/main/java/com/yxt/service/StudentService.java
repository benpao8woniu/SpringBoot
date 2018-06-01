package com.yxt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.yxt.dao.StudentDao;
import com.yxt.entity.Student;
import com.yxt.mapper.StudentMapper;
import com.yxt.mappertest1.StudentMapperTest1;
import com.yxt.mappertest2.StudentMapperTest2;

@Service
public class StudentService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private StudentMapperTest2 studentMapperTest2;
	@Autowired
	private StudentMapperTest1 studentMapperTest1;
	
	public void updateStudent(String name,int id){
		
		int i = jdbcTemplate.update("update member set name=? where id=?", name,id);
		System.out.println(i);
	}
	
	public Student fetchStudent(int id){
		return studentDao.findOne(id);
	}
	
	public Student fetchstudentMapper(int id){
		return studentMapper.fetchStudent(id);
	}
	
	public Student fetchstudentMapperTest2(int id){
		return studentMapperTest1.fetchStudent(id);
	}
	
	public Student fetchstudentMapperTest1(int id){
		return studentMapperTest2.fetchStudent(id);
	}
	
	
}
