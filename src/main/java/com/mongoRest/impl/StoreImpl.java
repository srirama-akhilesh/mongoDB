package com.mongoRest.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation.ProjectionOperationBuilder;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mongodb.client.model.Projections;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongoRest.dto.StoreDetailsDto;
import com.mongoRest.dto.StoreDetailsResponse;
import com.mongoRest.entity.StoreDetails;

@Component
public class StoreImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(StoreImpl.class);
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	StoreDetailsResponse response= new StoreDetailsResponse();
	
	public StoreDetailsResponse getCityByRating() {
		
		LOGGER.info("We are applying aggregations after retrieving the results from mongoDB");
		
		
		SortOperation sort= Aggregation.sort(Direction.DESC,"reviewCount");
				
		MatchOperation match= Aggregation.match(new Criteria("stars").gt(2));
		
		ProjectionOperationBuilder projection= Aggregation.project("storeName","city","stars","reviewCount").and("city");
				
		Aggregation agg= Aggregation.newAggregation(sort,match,projection);	
		
		AggregationResults<StoreDetailsResponse> result= mongoTemplate.aggregate(agg, StoreDetails.class, StoreDetailsResponse.class);
		
		List<StoreDetailsResponse> topTopics = result.getMappedResults();
		
		
		return response;
	}
	
	
	public List<StoreDetails> getCityByStore(String city) {
		
	//	Query query= new Query();
	//	query.addCriteria(Criteria.where("storeName").is("Winco"));
	  //StoreDetailsResponse result=  (StoreDetailsResponse) mongoTemplate.findById(storeName, StoreDetailsResponse.class);
		
	Query query = new Query();
	query.addCriteria(Criteria.where("city").is(city));
	 List<StoreDetails> result = mongoTemplate.find(query, StoreDetails.class);
		
	 return result;	
			
	}
	
	public StoreDetails createStore(StoreDetails storeDetails) {

			StoreDetails st = mongoTemplate.save(storeDetails);
			return st;

	}
	
	public StoreDetails updateStorebyName(String storeName) {
		
		Query query= new Query();
		query.addCriteria(Criteria.where("storeName").is(storeName));
		Update st= new Update();
		st.set("Stars", 9);
		StoreDetails updateStore= mongoTemplate.findAndModify(query, st,new FindAndModifyOptions().returnNew(true), StoreDetails.class);
		
		return updateStore;
		
	
	}
	
}
