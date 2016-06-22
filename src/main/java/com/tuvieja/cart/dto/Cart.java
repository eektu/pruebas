package com.tuvieja.cart.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.bson.types.ObjectId;
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
	private @Property Date timeStamp;
	private @Property String cartStatus;

	public Cart() {
		this.products = new ArrayList<Product>();
	}

	public Cart(String userId) {
		this.userId = userId;
	}

	public void addToCart(Product p) {
		products.add(p);
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Date getTimeStamp() {
		// SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		// return sdf.format(timeStamp);
		return timeStamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Collection<Product> getProductsFull() {
		return products;
	}

	public Collection<String> getProductsSummary() {
		ArrayList<String> s = new ArrayList<String>();
		for (Product p : products) {
			s.add(p.getGarbaId());
		}
		return s;
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

	public ObjectId getId() {
		return id;
	}
}
