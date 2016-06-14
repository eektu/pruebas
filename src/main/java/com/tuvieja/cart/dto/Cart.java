package com.tuvieja.cart.dto;

import java.util.Collection;

public  class Cart {
	private String cartId;
	private String userId;
	private Collection<Product> products;
	
	public Cart (){
	}
	
	public Cart (String cartId, String userId){
		this.cartId = cartId;
		this.userId = userId;
	}

	public String getId (){
		return cartId;
	}

	public String getUser (){
		return userId;
	}
	
	public Collection<Product> getMensaje (){
		return products;
	}
}
