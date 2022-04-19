package com.greatLearning.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.studentManagement.entity.Student;
import com.greatLearning.studentManagement.service.StudentService;




@Controller
@RequestMapping("/student")
public class StudentController {

	//Autowire Student Service
	@Autowired
	private StudentService studentService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String liststudents(Model theModel) {

		System.out.println("Request Received");
		// get Books from db
		List<Student> student = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("Student", student);

		return "list-Students";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the Book
		studentService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/student/list";

	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student newstudent = new Student();
		System.out.println("show form for add" + newstudent );
		theModel.addAttribute("Student", newstudent);

		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
			Model theModel) {

		// get the Book from the service
		Student newstudent = studentService.findById(theId);


		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Student", newstudent);

		// send over to our form
		return "Student-form";			
	}
	
	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id,
			@RequestParam("name") String name,@RequestParam("department") String department,@RequestParam("country") String country) {

		System.out.println(id);
		Student student;
		if(id!=0)
		{
			student=studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}
		else
			student=new Student(name, department, country);
		// save the Book
		studentService.save(student);


		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list";

	}
		
		

	
	}
	



















