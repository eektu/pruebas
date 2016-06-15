package com.tuvieja.cart.dto;

public class Product {
	private String garbaId;
	private String description;
	private float price;
	private Image mainImage;

	public Product() {
		this.garbaId = "";
		this.description = "default";
		this.price = 0f;
		this.mainImage = new Image();
	}

	public Product(String garbaId, String description, float price, Image mainImage) {
		this.garbaId = garbaId;
		this.description = description;
		this.price = price;
		this.mainImage = mainImage;
	}

	public void setProductId(String garbaId) {
		this.garbaId = garbaId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setMainImage(Image mainImage) {
		this.mainImage = mainImage;
	}

	public String getGarbaId() {
		return garbaId;
	}

	public float getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public Image getMainImage() {
		return mainImage;
	}
}
