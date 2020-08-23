package com.mongoRest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongoRest.dto.StoreDetailsDto;
import com.mongoRest.dto.StoreDetailsResponse;
import com.mongoRest.entity.StoreDetails;
import com.mongoRest.impl.StoreImpl;

@RestController
public class StoreDetailsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StoreDetailsController.class);
	
	@Autowired
	StoreImpl storeImpl;
	
	
	
	
	@GetMapping("/getCityByRatings")
	public StoreDetailsResponse getCity() {
	
		LOGGER.info("Correctlation id from MDC "+ MDC.get("correlationID"));
		return storeImpl.getCityByRating();
	}
	
	@PostMapping("/createStore")
	public ResponseEntity<StoreDetails> createStore(@RequestBody StoreDetails storeDetails) {
		LOGGER.info("Creating new Store Details in collection");
		
		try {
			
		StoreDetails newSt= storeImpl.createStore(storeDetails);
		return new ResponseEntity<>(newSt,HttpStatus.CREATED);
	}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@GetMapping("/getStoreByCityName/{city}")
	public List<StoreDetails> getStore(@PathVariable String city) {
		
		LOGGER.info("Correctlation id from MDC "+ MDC.get("correlationID"));
		return storeImpl.getCityByStore(city);
	}
	
	@PutMapping("/updateStoreByName/{stName}")
	public ResponseEntity<StoreDetails> updateStoreByName(@PathVariable String stName) {
		LOGGER.info("Updating the Store Details");
		
		try {
		StoreDetails updateSt= storeImpl.updateStorebyName(stName);
		
		return new ResponseEntity<>(updateSt,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.REQUEST_TIMEOUT);
		}
		
	}
	
	
	
	
}
