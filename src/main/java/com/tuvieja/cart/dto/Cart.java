package com.tuvieja.cart.dto;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;

/*
 * cartStatus: {"cart created", "cart updated", "cart bought"}
 */

public @Entity(noClassnameStored = true, value = "Carts") class Cart {
	
	private @Id ObjectId id;
	private @Indexed String userId;
	private Collection<Product> products;
	private @Property DateTime timeStamp;
	private @Property String cartStatus;
	
	public Cart (){
	}
	
	public Cart (String userId){
		this.userId = userId;
	}

	public void setTimeStamp(DateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public DateTime getTimeStamp() {
		return timeStamp;
	}

	public String getUserId (){
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;

	}
	
	public Collection<Product> getCartProducts (){
		return products;
	}
	
	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public String getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
}
