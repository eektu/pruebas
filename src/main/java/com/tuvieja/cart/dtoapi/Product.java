package com.tuvieja.cart.dtoapi;

import java.awt.Image;

public class Product {
	private String xid;
	private String description;
	private float price;
	private Image mainImage;
	
	public Product (){
		this.xid = "";
		this.price = 0f;
	}
	
	public Product (String xid, String description, float price, Image mainImage){
		this.xid = xid;
		this.description = description;
		this.price = price;
		this.mainImage = mainImage;
	}

	public String getId() {
		return xid;
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
