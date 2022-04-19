package com.greatLearning.studentManagement.service;

import java.util.List;

import com.greatLearning.studentManagement.entity.Student;

public interface StudentService {
		
		public List<Student> findAll();
		
	//	public List<Student> searchBy(String name,String author);
		
		public Student findById(int id);
		
		public void save(Student student); // save or update
		
		public void deleteById(int id);

		
	}
	

