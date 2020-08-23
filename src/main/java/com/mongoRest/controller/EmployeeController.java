package com.mongoRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongoRest.dto.EmployeeDto;
import com.mongoRest.entity.Employee;
import com.mongoRest.impl.EmpImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.*;

@RestController
@Api(value="This is Employee Controller")
public class EmployeeController {
	

	@Autowired
	EmpImpl empImpl;
	
	@PostMapping("/createEmployee")
	@ApiOperation(value = "This rest request will create a new employee record")
	@ApiResponses(value= {
			
			@ApiResponse(code= 201, message="Ok"),
			@ApiResponse(code= 401, message="Not Authorized"),
			@ApiResponse(code= 403, message="Forbidden")
			
	})
	public Employee createEmployee(@RequestBody EmployeeDto employeeDto){
		
		return empImpl.createEmployee(employeeDto);
	}
		
	@GetMapping("/employee/{id}") 
	@ApiOperation(value = "This will fetch employee record")
	@ApiResponses(value= {
			
			@ApiResponse(code= 200, message="Ok", response=Employee.class),
			@ApiResponse(code= 401, message="Not Authorized"),
			@ApiResponse(code= 403, message="Forbidden")
			
	})
	ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		
		return empImpl.getEmployee(id);
	}
		
	@GetMapping("/getNames")
	public AggregationResults<EmployeeDto> getNamesByCompany() {
		
		return empImpl.getNamesByCompany();
	}
	}


