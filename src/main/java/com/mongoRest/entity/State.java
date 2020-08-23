package com.mongoRest.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="States")
@Data
public class State {

	@Id
	public String id;
	
	
	public String name;
	
	public int zip;
	
	public double population;

	public State( String name, int zip, double population) {
		super();
		
		//this.id=id;
		this.name = name;
		this.zip = zip;
		this.population = population;
	}
	
	
}
