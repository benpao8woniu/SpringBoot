package com.yxt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yxt.entity.Student;

public interface StudentDao extends  JpaRepository<Student, Integer>{

}
