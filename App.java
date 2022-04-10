package com.greatLearning;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatLearning.studentManagement.entity.Student;
import com.greatLearning.studentManagement.service.StudentService;
import com.greatLearning.studentManagement.service.StudentServiceImpl;

public class App {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		StudentService studentService = new StudentServiceImpl(sessionFactory);
	//	Student student =new Student("ABh", "IT", "AUSTRALIA");
	//	studentService.save(student);
	//	System.out.println(studentService.findById(1));
		Student student =studentService.findById(2);
		student.setCountry("India");
		studentService.save(student);
	
		List<Student> students = studentService.findAll();
		for(Student stdent:students) {
			System.out.println(student);
	}
		
		
		
	/*	students = studentService.searchBy("Javascript", "shree");
		for(Student student:students) {
			System.out.println(student);
		} */
		
		//	studentService.deleteById(1);
//		for(Student student:students) {
//			System.out.println(student);
//		} 
	}

}