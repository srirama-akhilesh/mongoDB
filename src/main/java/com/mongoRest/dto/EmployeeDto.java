package com.mongoRest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;


public class EmployeeDto {
	

	//@JsonProperty(value="NAME")
   public String name;
	
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

	public String department;
	
	public String company;
	
	public double salary;

}
