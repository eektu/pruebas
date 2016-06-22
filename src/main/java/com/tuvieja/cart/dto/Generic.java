package com.tuvieja.cart.dto;

public class Generic {
	private String garbaId;
	private int quantity;

	public Generic() {
	}

	public Generic(String garbaId, int quantity) {
		this.garbaId = garbaId;
		this.quantity = quantity;
	}

	public String getGarbaId() {
		return garbaId;
	}

	public void setGarbaId(String garbaId) {
		this.garbaId = garbaId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
