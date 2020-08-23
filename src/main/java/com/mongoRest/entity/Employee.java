package com.mongoRest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Document(collection="Employee")
public class Employee {
	
	@Id
	public String id;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String name;
	
	public String department;
	
	public String company;
	
	public double salary;

	public Employee(String name, String department, String company, double salary) {
		super();
		//this.id = id;
		this.name = name;
		this.department = department;
		this.company = company;
		this.salary = salary;
	}
	
	

}
