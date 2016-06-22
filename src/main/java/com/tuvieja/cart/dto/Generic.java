package com.tuvieja.cart.dto;

public class Generic {

	private String garbaProduct;

	public Generic (){
	}
	
	public Generic (String garbaProduct){
		this.garbaProduct = garbaProduct;
	}
	
	public String getGarbaProduct() {
		return garbaProduct;
	}

	public void setGarbaProduct(String garbaProduct) {
		this.garbaProduct = garbaProduct;
	}
}
