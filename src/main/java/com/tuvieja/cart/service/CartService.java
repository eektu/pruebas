package com.tuvieja.cart.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.joda.time.DateTime;

import com.tuvieja.cart.dao.CartDao;
import com.tuvieja.cart.dto.Cart;

/*
 * VERIFICACIONES:
 * - Ver que existan los registros a modificar
 * - Ver que existan las referencias (userId, productId, etc), llamar a los DAOs correspondientes 
 * 
 */

public class CartService {
	private @Resource CartDao cd;

	public Cart fetchOne(String cartId) {
		return cd.fetchOne(cartId);
	}

	public Collection<Cart> fetchAll() {
		return cd.fetchAll();
	}

	public void createCart(Cart cart) {
		// verificar que exista el usuario, llamar al UserDao
		cart.setTimeStamp(DateTime.now());
		cart.setCartStatus("cart created");
		cd.createCart(cart);
	}

	public void buyCart(String cartId, Cart cart) {
		// verificar que exista el carrito
		// verificar que solo cambie el status (que lo hacemos acá)
		if (cd.exists(cartId)) {
			cart.setCartStatus("cart boght");
			cd.editCart(cartId, cart);
		}
	}

	public void editCart(String cartId, Cart cart) {
		// verificar que exista el carrito
		// no permitir que cambie el usuario,
		cd.editCart(cartId, cart);
	}

	public void deleteCart(String cartId) {
		if (cd.exists(cartId)) {
			cd.deleteCart(cartId);
		}
	}

	// public float getDiscount (String cartId) {
	// Cart cart = fetchOne (cartId);
	// float discount = 0f;
	// for (Product p : cart.getCartProducts()){
	// discount += Math.random() * p.getPrice();
	// }
	// return discount;
	// }
}
