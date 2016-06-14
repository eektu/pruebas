package com.tuvieja.cart.dto;

public class Product {
	private String productId;
	private String description;
	private float price;
	private Image mainImage;
	
	public Product (){
		this.productId = "";
		this.price = 0f;
	}
	
	public Product (String productId, String description, float price, Image mainImage){
		this.productId = productId;
		this.description = description;
		this.price = price;
		this.mainImage = mainImage;
	}

	public String getProductId() {
		return productId;
	}

	public float getPrice() {
		return price;
	}
	
	public String getDescription (){
		return description;
	}
	
	public Image getMainImage (){
		return mainImage;
	}
}
