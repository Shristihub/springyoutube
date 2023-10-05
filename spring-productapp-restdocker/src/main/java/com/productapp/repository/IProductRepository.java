package com.productapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;

@Repository
public interface IProductRepository extends MongoRepository<Product, String>{

	
	// derived query
	// findBy or readBy or getBy followed by the property name
	List<Product> findByBrand(String brand);
	List<Product> findByCategory(String[] category);
	
	List<Product> findByFeaturesColor(String color);
	List<Product> findByBrandAndPriceLessThan(String brand, double price);
	
	// custom query
	@Query("{'features.color':?0}")
	List<Product> findByColor(String color);
	
//	@Query("{brand:?0,price:{$lt:?1}}")
	@Query("{$and:[{brand:?0,price:{$lt:?1}}]}")
	List<Product> findByBrandPrice(String brand, double price);
	
}







