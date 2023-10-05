package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.ProductDto;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("/product-api/v1")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
//	ResponseEntity<T>
//	// headers,status, body


//	http://localhost:8080/product-api/v1/products
	@PostMapping("/products")
	ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto){
		productService.addProduct(productDto);
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
	}
	
//	http://localhost:8080/product-api/v1/products
	@PutMapping("/products")
	ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto){
		productService.updateProduct(productDto);
//		return ResponseEntity.status(202).build();
		return ResponseEntity.accepted().build();
	}
	
//	http://localhost:8080/product-api/v1/products/productId/A001
	@DeleteMapping("/products/productId/{productId}")
	ResponseEntity<Void> deleteProduct(@PathVariable("productId")String  productId){
		productService.deleteProduct(productId);
		return ResponseEntity.accepted().build();
	}
//	http://localhost:8080/product-api/v1/products
	@GetMapping("/products")
	ResponseEntity<List<ProductDto>> getAll(){
		List<ProductDto> productDtos = productService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Getting all products");
		ResponseEntity<List<ProductDto>> responseEntity = 
				new ResponseEntity<List<ProductDto>>(productDtos, headers, HttpStatusCode.valueOf(200));
		return responseEntity;
	}
	
//	http://localhost:8080/product-api/v1/products/productId/A001
	@GetMapping("/products/productId/{productId}")
	ResponseEntity<ProductDto> getById(@PathVariable("productId") String  productId){
		ProductDto productDto = productService.getById(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Getting one product by id "+productId);
		return ResponseEntity.status(200).headers(headers).body(productDto);
	}
	
//	http://localhost:8080/product-api/v1/products/brand/Samsung
	@GetMapping("/products/brand/{br}")	
	ResponseEntity<List<ProductDto>> getByBrand(@PathVariable String brand){
		List<ProductDto> productDtos = productService.getByBrand(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Getting products by brand "+brand);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).headers(headers).body(productDtos);
		
	}
//	http://localhost:8080/product-api/v1/products/category/sports,kids
	@GetMapping("/products/category/{category}")	
	ResponseEntity<List<ProductDto>>  getByCategory(@PathVariable("category")String[] category){
		List<ProductDto> productDtos = productService.getByCategory(category);
		return ResponseEntity.ok(productDtos);
	}
	
//	http://localhost:8080/product-api/v1/products/color?color=blue
	@GetMapping("/products/color")	
	ResponseEntity<List<ProductDto>> getByColor(@RequestParam("color") String color){
		List<ProductDto> productDtos = productService.getByColor(color);
		return ResponseEntity.ok(productDtos);
	}
	
//	http://localhost:8080/product-api/v1/products/brand/Samsung/price/1000.0
	@GetMapping("/products/brand/{brand}/price/{price}")	
	ResponseEntity<List<ProductDto>> getByBrandAndLesserPrice(@PathVariable("brand")String brand,@PathVariable("price")double price){
		List<ProductDto> productDtos = productService.getByBrandAndLesserPrice(brand, price);
		return ResponseEntity.ok(productDtos);
	}
}







