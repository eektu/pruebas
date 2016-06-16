package com.tuvieja.cart.dtoapi;

public class GarbaProduct {
	
	private String xid;
	private String description;
	private float price;
	private GarbaImage mainImage;
	
	public GarbaProduct (){
		this.xid = "";
		this.price = 0f;
	}
	
	public GarbaProduct (String xid, String description, float price, GarbaImage mainImage){
		this.xid = xid;
		this.description = description;
		this.price = price;
		this.mainImage = mainImage;
	}
	
	public String getXid() {
		return xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setMainImage(GarbaImage mainImage) {
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
	
	public GarbaImage getMainImage (){
		return mainImage;
	}
}
