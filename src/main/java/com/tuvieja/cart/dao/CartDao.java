package com.tuvieja.cart.dao;

import java.util.Collection;

import org.jboss.logging.Property;

import com.tuvieja.cart.dto.Cart;
public class CartDao {
//public @Entity(noClassnameStored = true, value = "shopping_cart") class CartDao {
//	private @Id ObjectId id;
//	private @Property("brand") String brand;
//	
	public Cart fetchOne (String cartId){
		return null;
	}
	
	public Collection<Cart> fetchAll (){
		return null;
	}
	
	public void createCart (Cart cart){}
	
	public void editCart (String cartId, Cart cart){}
	
	public void deleteCart (String cartId){}
}
