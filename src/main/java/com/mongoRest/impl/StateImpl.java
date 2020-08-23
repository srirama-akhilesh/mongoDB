package com.mongoRest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation.ProjectionOperationBuilder;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mongoRest.dto.StateDto;
import com.mongoRest.entity.Employee;
import com.mongoRest.entity.State;

@Component
public class StateImpl {

	
	@Autowired
	MongoTemplate mongoTemplate;
	
public List<StateDto> getStatesByPop(){
		
		
		SortOperation sortByPop = Aggregation.sort(Direction.ASC,"population");
		
		MatchOperation filterStates = Aggregation.match(new Criteria("population").gt(30000));
		        
		ProjectionOperationBuilder projection= Aggregation.project("name","zip","population").and("name");
		
		Aggregation aggregation 
		  = Aggregation.newAggregation(filterStates, sortByPop,projection);
		
		AggregationResults<StateDto> result= mongoTemplate.aggregate(aggregation, State.class, StateDto.class);
		
		List<StateDto> output= result.getMappedResults();
		
		return output;
	
			
		
	}




	
	
	
	
	
	
	
			
			
}
//public void getCountriesByName(String department,double salary) {


	//MatchOperation matchStage = Aggregation.
			//match(new Criteria("country").is(country));}

	


