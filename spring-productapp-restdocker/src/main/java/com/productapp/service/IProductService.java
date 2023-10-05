package com.productapp.service;

import java.util.List;

import com.productapp.exceptions.InvalidIdException;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.ProductDto;

public interface IProductService {

	// CRUD operations - inbuilt methods
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(String  productId);
	
	List<ProductDto> getAll();
	ProductDto getById(String  productId) throws InvalidIdException;
	
	// derived queries
	List<ProductDto> getByBrand(String brand)throws ProductNotFoundException;
	List<ProductDto> getByCategory(String[] category)throws ProductNotFoundException;
	
	//custom query
	List<ProductDto> getByColor(String color)throws ProductNotFoundException;
	List<ProductDto> getByBrandAndLesserPrice(String brand,double price)throws ProductNotFoundException;
	
	
	
}
