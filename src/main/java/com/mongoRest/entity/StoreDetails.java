package com.mongoRest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(collection="StoreDetails")
@Data
@Setter
@Getter
public class StoreDetails {
	
	@Id
	public String id;
	
	public String storeName;
	
	public String city;
	
	public int stars;
	
	public int reviewCount;

	public StoreDetails(String storeName, String city, int stars, int reviewCount) {
		super();
		this.storeName = storeName;
		this.city = city;
		this.stars = stars;
		this.reviewCount = reviewCount;
	}
	
	public StoreDetails() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	


}
