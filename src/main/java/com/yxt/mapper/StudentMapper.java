package com.yxt.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yxt.entity.Student;

public interface StudentMapper {
	
	@Select("select * from member where id=#{id}")
	public Student fetchStudent(@Param("id") int id);

}
