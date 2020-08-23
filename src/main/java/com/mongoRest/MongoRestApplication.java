package com.mongoRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongoRest.entity.State;
import com.mongoRest.entity.StoreDetails;



@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public  class MongoRestApplication {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(MongoRestApplication.class, args);
	}
	
	
	
		

	}

