package com.tuvieja.cart.service;

import java.util.Collection;

import javax.annotation.Resource;

import com.tuvieja.cart.dao.CartDao;
import com.tuvieja.cart.dto.Cart;

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
}
