package com.tuvieja.cart.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import com.tuvieja.cart.dao.CartDao;
import com.tuvieja.cart.dto.Cart;
import com.tuvieja.cart.dto.CartLite;
import com.tuvieja.cart.dto.Product;
import com.tuvieja.cart.service.utils.CartTransform;

/*
 * VERIFICACIONES:
 * - Ver que existan los registros a modificar
 * - Ver que existan las referencias (userId, productId, etc), llamar a los DAOs correspondientes 
 * 
 */

public class CartService {
	private @Resource CartDao cd;
	private @Resource ProductService ps;

	public Cart fetchOne(String cartId) {
		return cd.fetchOne(cartId);
	}

	public Collection<Cart> fetchAll() {
		return cd.fetchAll();
	}

	public void addToCart(String cartId, String productId) {
		if (cd.itExists(cartId) && ps.itExists(productId)) {
			System.out.println("{CARTS} adding product (" + productId + ") @ CARTSERVICE");
			Cart c = fetchOne (cartId);
			Product p = ps.fetchOne(productId);
			c.addToCart(p);
			cd.editCart(cartId, c);
		}
	}

	public void createCart(Cart cart) {
		// verificar que exista el usuario, llamar al UserDao
		cart.setTimeStamp(new Date());
		cart.setCartStatus("cart created");
		cd.createCart(cart);
	}

	public void buyCart(String cartId, Cart cart) {
		// verificar que exista el carrito
		// verificar que solo cambie el status (que lo hacemos acá)
		if (cd.itExists(cartId)) {
			cart.setCartStatus("cart bought");
			cd.editCart(cartId, cart);
		}
	}

	public void editCart(String cartId, Cart cart) {
		cd.editCart(cartId, cart);
	}

	public void deleteCart(String cartId) {
		if (cd.itExists(cartId)) {
			cd.deleteCart(cartId);
		}
	}

	public Collection<Product> fetchAllItems (String cartId){
		if (cd.itExists(cartId)){
			return cd.fetchAllItems (cartId);
		}
		return new ArrayList<Product> ();
	}

	public CartLite fetchOneLite(String cartId) {
		return CartTransform.toLite(fetchOne (cartId));
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
