package com.sss.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sss.product_service.entity.Product;
import com.sss.product_service.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	// create Product Rest API
	
	@PostMapping
	public Product addProduct(@RequestBody Product product)
	{
		return productRepository.save(product);
	}
	
	// get all product Rest API
	
	@GetMapping
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	// get product by id Rest API
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId)
	{
		Product product = productRepository.findById(productId)
				.orElseThrow(()->new RuntimeException("Product not Found with ID " + productId));
		return ResponseEntity.ok(product);
	}

}
