package com.edusol.products.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edusol.products.model.Product;
import com.edusol.products.repository.ProductRepository;

@Service
public class ProductService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	ProductRepository productRepository;

	public Object getProducts() {
		
		return productRepository.findAll();
	}

	public Object addProduct(Product product) {
		logger.info(product.toString());
		productRepository.save(product);
		logger.info("Product Added Successfully.");
		
		return new ResponseEntity<> ("Product added successfully.",HttpStatus.CREATED);
	}

	public Object getProductById(int id) {
		
		return productRepository.findById(id);
	}

	public Object getProductByCategory(String category) {
		logger.info(category.toString());
		return productRepository.findByCategory(category);
	}

	public Object updateProduct(Product product) {
		
	
		
		System.out.println("Request product :"+product);
		int id =product.getProductId();
		try {

			Product prod = productRepository.getOne(id);
			System.out.println("Request product :"+prod);
			
			System.out.println("Old product :"+prod);
			prod.setPrice(product.getPrice());
			System.out.println("New product :"+prod);
			productRepository.save(prod);
			}catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<> (e.getMessage(), HttpStatus.NOT_FOUND);
			}
		logger.info("Product updated Successfully.");
		return new ResponseEntity<> ("Product updated Successfully.", HttpStatus.OK);
	}

	public Object deleteProduct(int id) {
		try {
		productRepository.deleteById(id);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<> (e.getMessage(), HttpStatus.NOT_FOUND);
		}
		logger.info("Product deleted Successfully.");
		return new ResponseEntity<> ("Product deleted Successfully.", HttpStatus.OK);
	}

	public Object getProductByPrice(float price) {
		
		return productRepository.findByPrice(price);
	}

	public Object getProductByPriceAndCategory(float price, String category) {
		
		return productRepository.findByPriceAndCategory(price, category);
	}

	public Object getProductByPriceRange(float min, float max) {
		
		return productRepository.findByPriceBetween(min,max);
	}

	public Object getProductByPriceRangeAndCategory(float min, float max, String category) {
		return productRepository.findByPriceBetweenAndCategory(min, max, category);
	}

	
	

	

}
