package com.tuvieja.cart.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;

import com.tuvieja.cart.utils.Discounter;

/*
 * cartStatus: {"cart created", "cart updated", "cart bought"}
 */

public @Entity(noClassnameStored = true, value = "Carts") class Cart {

	private @Id ObjectId id;
	private @Indexed @Property("user_id") String userId;
	private @Property("items") Collection<CartItem> items;
	private @Property("time_stamp") Date timeStamp;
	private @Property("cart_status") String cartStatus;

	public Cart() {
		this.items = new ArrayList<CartItem>();
	}

	public Cart(String userId) {
		this.userId = userId;
	}

	public void removeAllFromCart(String productId) {
		ArrayList<CartItem> newItems = new ArrayList<CartItem>();
		for (CartItem c : items) {
			if (!c.getProduct().getGarbaId().equals(productId)){
				newItems.add(c);
			}
		}
		this.items = newItems;
	}
	
	public void removeSomeFromCart(String productId, int quantity) {
		ArrayList<CartItem> newItems = new ArrayList<CartItem>();
		for (CartItem c : items) {
			if (c.getProduct().getGarbaId().equals(productId)){
				if (c.getQuantity() > quantity){
					c.setQuantity(c.getQuantity() + quantity);
				}else{
					c.setQuantity(0);
				}
			}
			if (c.getQuantity() > 0){
				newItems.add(c);
			}
		}
		this.items = newItems;
	}

	public void addToCart(CartItem ci) {
		boolean edited = false;
		for (CartItem c : items) {
			if (c.getProduct().getGarbaId().equals(ci.getProduct().getGarbaId())){
				c.setQuantity(c.getQuantity() + ci.getQuantity());
				edited = true;
			}
		}
		if (!edited){
			items.add(ci);
		}
	}
	
	public float getDiscount(){
		float discount = 0f;
		for (CartItem c : items){
			discount += Discounter.getDiscount(c.getProduct().getPrice(), c.getQuantity());
		}
		discount = Math.round(discount * 100) / 100f;
		return discount;
	}
	
	public float getTotal(){
		float total = 0f;
		for (CartItem c : items){
			total += c.getProduct().getPrice() * c.getQuantity();
		}
		return total;
	}
	
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Collection<CartItem> getCartItems() {
		return items;
	}

	public void setCartItems(Collection<CartItem> items) {
		this.items = items;
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
