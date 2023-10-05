package com.productapp.model;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public ProductDto convertToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setBrand(product.getBrand());
		productDto.setCategory(product.getCategory());
		productDto.setFeatures(product.getFeatures());
		productDto.setPrice(product.getPrice());
		return productDto;
	}
	
	public Product convertToProduct(ProductDto productDto) {
		Product product = new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setBrand(productDto.getBrand());
		product.setCategory(productDto.getCategory());
		product.setFeatures(productDto.getFeatures());
		product.setPrice(productDto.getPrice());
		return product;
	}
}
