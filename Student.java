package com.greatLearning.studentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")


public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String Department;
	
	@Column
	private String Country;
	
	public Student()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Student(String name, String department, String country) {
		super();
		this.name = name;
		Department = department;
		Country = country;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Department=" + Department + ", Country=" + Country + "]";
	}

	
}











