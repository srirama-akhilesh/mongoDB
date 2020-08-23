package com.mongoRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongoRest.dto.StateDto;
import com.mongoRest.impl.StateImpl;

@RestController
public class StatePopulation {

	
	@Autowired
	StateImpl sImpl;
	
	
	@GetMapping("/getSList")
	public List<StateDto> getStatesByPopulation() {
		
		return sImpl.getStatesByPop();
	}
	
	
	
	
}
