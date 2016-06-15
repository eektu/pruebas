package com.tuvieja.cart.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
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

	public Cart fetchOne(ObjectId id) {
		return cd.fetchOne(id);
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

	public void buyCart(ObjectId id, Cart cart) {
		// verificar que exista el carrito
		// verificar que solo cambie el status (que lo hacemos acá)
		if (cd.exists(id)) {
			cart.setCartStatus("cart boght");
			cd.editCart(id, cart);
		}
	}

	public void editCart(ObjectId id, Cart cart) {
		cd.editCart(id, cart);
	}

	public void deleteCart(ObjectId id) {
		if (cd.exists(id)) {
			cd.deleteCart(id);
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
