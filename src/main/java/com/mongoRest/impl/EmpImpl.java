package com.mongoRest.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mongoRest.dto.EmployeeDto;
import com.mongoRest.entity.Employee;

@Component
public class EmpImpl {


	@Autowired
	MongoTemplate mongoTemplate;


	public Employee createEmployee(EmployeeDto employeeDto){
		
		Employee emp = new Employee(employeeDto.getName(),employeeDto.getDepartment(),employeeDto.getCompany(),employeeDto.getSalary());

		return mongoTemplate.save(emp);
	}
	
	public  ResponseEntity<Employee> getEmployee(Long id){
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));

		Employee employee = mongoTemplate.findOne(query, Employee.class);
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}

public AggregationResults<EmployeeDto> getNamesByCompany() {
		
		ProjectionOperation proj= Aggregation.project("name").andInclude("department");
		
		MatchOperation match= Aggregation.match(new Criteria("department").size(2));
		
		Aggregation agg= Aggregation.newAggregation(proj,match);
		
		AggregationResults<EmployeeDto> result1= mongoTemplate.aggregate(agg, Employee.class,EmployeeDto.class);
		
		return result1;
	}
}


