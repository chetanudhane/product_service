package com.edusol.products.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@Column (name = "ID")
	private int productId;
	
	@Column (name = "PRODUCT_NAME")
	private String name;
	
	@Column (name = "PRODUCT_PRICE")
	private float price;
	
	@Column (name = "PRODUCT_CATEGORY")
	private String category;
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", category=" + category
				+ "]";
	}
	
	

}
