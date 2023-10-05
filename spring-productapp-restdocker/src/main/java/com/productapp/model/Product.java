package com.productapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document 
//@Document(collection = "newproduct")
public class Product {
	private String productName;
	@Id
	private	String productId;
	private Features features;
	private String brand;
	private String[] category;
	@Field(name="cost")
	private double price;

}
