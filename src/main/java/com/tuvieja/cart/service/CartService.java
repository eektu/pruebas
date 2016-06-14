package com.tuvieja.cart.service;

import java.util.Collection;

import javax.annotation.Resource;

import com.tuvieja.cart.dao.CartDao;
import com.tuvieja.cart.dto.Cart;
import com.tuvieja.cart.dto.Product;

public class CartService {
	private @Resource CartDao cd;

	public Cart fetchOne (String cartId){
		return cd.fetchOne (cartId);
	}
	
	public Collection<Cart> fetchAll (){
		return cd.fetchAll ();
	}
	
	public void createCart (Cart cart){
		cd.createCart (cart);
	}
	
	public void editCart (String cartId, Cart cart){
		cd.editCart (cartId, cart);
	}
	
	public void deleteCart (String cartId){
		cd.deleteCart (cartId);
	}
	
	public float getDiscount (String cartId) {
		Cart cart = fetchOne (cartId);
		float discount = 0f;
		for (Product p : cart.getCartProducts()){
			discount += Math.random() * p.getPrice();
		}
		return discount;
	}
}
