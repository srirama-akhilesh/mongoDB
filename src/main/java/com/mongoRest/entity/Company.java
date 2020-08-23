package com.mongoRest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(value="Company Details")
@Data
@Setter
@Getter
public class Company {

	
	@Id
	public String name;
	
	public double population;

	public Company(Long id, String name, double population) {
		super();

		this.name = name;
		this.population = population;
	}
	
	
}
