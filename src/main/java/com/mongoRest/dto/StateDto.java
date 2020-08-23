package com.mongoRest.dto;

import org.springframework.data.annotation.Id;

public class StateDto {

	
	
	public String id;
	
	
	public String name;
	
	public int zip;
	
	public double population;

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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}
}
