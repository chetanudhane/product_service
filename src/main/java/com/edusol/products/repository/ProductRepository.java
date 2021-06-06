package com.edusol.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.products.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByCategory(String category);
	List<Product> findByPrice(float price);
	List<Product> findByPriceAndCategory(float price, String category);
	List<Product> findByPriceBetween(float min, float max);
	List<Product> findByPriceBetweenAndCategory(float min, float max,String category);
}
