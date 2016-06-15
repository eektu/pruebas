package com.tuvieja.cart.dto;

public class Product {
	private String productId;
	private String description;
	private float price;
	private Image mainImage;

	public Product() {
		this.productId = "";
		this.description = "default";
		this.price = 0f;
		this.mainImage = new Image();
	}

	public Product(String productId, String description, float price, Image mainImage) {
		this.productId = productId;
		this.description = description;
		this.price = price;
		this.mainImage = mainImage;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getProductId() {
		return productId;
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
