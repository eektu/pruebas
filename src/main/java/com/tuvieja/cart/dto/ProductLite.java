package com.tuvieja.cart.dto;

public class ProductLite {

	private String garbaId;
	private String description;

	public ProductLite() {
		this.garbaId = "";
		this.description = "default";
	}

	public ProductLite(String garbaId, String description) {
		this.garbaId = garbaId;
		this.description = description;
	}

	public void setProductId(String garbaId) {
		this.garbaId = garbaId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGarbaId() {
		return garbaId;
	}

	public String getDescription() {
		return description;
	}
}
