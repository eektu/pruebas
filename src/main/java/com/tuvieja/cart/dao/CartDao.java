package com.tuvieja.cart.dao;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.garbarino.monga.dao.BaseDao;
import com.tuvieja.cart.dto.Cart;

public @Repository class CartDao extends BaseDao<Cart, String> {

	@Autowired
	public CartDao(Datastore ds) {
		super(Cart.class, ds);
	}

	public boolean exists(String cartId) {
		if (fetchOne(cartId) != null) {
			System.out.println(fetchOne(cartId).getUserId());
			return true;
		}
		return false;
	}

	public Cart fetchOne(String cartId) {
		return getDs().find(Cart.class).field("cartId").equalIgnoreCase(cartId).get();
	}

	public void createCart(Cart cart) {
		this.save(cart);
	}

	public void editCart(String cartId, Cart cart) {
	}

	public void deleteCart(String cartId) {
	}
}
