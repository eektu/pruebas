package com.tuvieja.cart.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.tuvieja.cart.dao.CartDao;
import com.tuvieja.cart.dto.Cart;
import com.tuvieja.cart.dto.CartItem;
import com.tuvieja.cart.dto.CartLite;
import com.tuvieja.cart.dto.Generic;
import com.tuvieja.cart.dto.Product;
import com.tuvieja.cart.service.utils.CartTransform;

public class CartService {
	private @Resource CartDao cd;
	private @Resource ProductService ps;

	public Cart fetchOne(String cartId) {
		return cd.fetchOne(cartId);
	}

	public Collection<Cart> fetchAll() {
		return cd.fetchAll();
	}

	public void updateQuantity(String cartId, Generic itemUpdate) {
		if (itemUpdate.getQuantity() < 0) {
			removeFromCart(cartId, itemUpdate);
		} else {
			addToCart(cartId, itemUpdate);
		}
	}

	public void deleteFromCart(String cartId, String productId) {
		if (cd.itExists(cartId) && ps.itExists(productId)) {
			Cart c = fetchOne(cartId);
			c.removeAllFromCart(productId);
			c.setCartStatus("cart updated");
			cd.editCart(cartId, c);
		}
	}

	public void removeFromCart(String cartId, Generic doomedItem) {
		if (cd.itExists(cartId) && ps.itExists(doomedItem.getGarbaId())) {
			System.out.println("{CARTS} adding " + doomedItem.getQuantity() + " product (" + doomedItem.getGarbaId()
					+ ") @ CARTSERVICE");

			Cart c = fetchOne(cartId);
			c.removeSomeFromCart(doomedItem.getGarbaId(), doomedItem.getQuantity());
			c.setCartStatus("cart updated");
			cd.editCart(cartId, c);
		}
	}

	public void addToCart(String cartId, Generic newItem) {
		if (cd.itExists(cartId) && ps.itExists(newItem.getGarbaId())) {
			System.out.println("{CARTS} adding " + newItem.getQuantity() + " product (" + newItem.getGarbaId()
					+ ") @ CARTSERVICE");

			Cart c = fetchOne(cartId);
			Product p = ps.fetchOne(newItem.getGarbaId());
			c.addToCart(new CartItem(p, newItem.getQuantity()));

			cd.editCart(cartId, c);
		}
	}

	public void createCart(Cart cart) {
		cart.setTimeStamp(new Date());
		cart.setCartStatus("cart created");
		cd.createCart(cart);
	}

	public void buyCart(String cartId, Cart cart) {
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

	public Collection<CartItem> fetchAllItems(String cartId) {
		if (cd.itExists(cartId)) {
			return cd.fetchAllItems(cartId);
		}
		return new ArrayList<CartItem>();
	}

	public CartLite fetchOneLite(String cartId) {
		return CartTransform.toLite(fetchOne(cartId));
	}

	public Collection<CartLite> fetchAllLite() {
		return cd.fetchAll().stream().map(c -> CartTransform.toLite(c)).collect(Collectors.toList());
	}

	public float getDiscount(String cartId) {
		float discount = 0f;
		if (cd.itExists(cartId)){
			Cart c = cd.fetchOne(cartId);
			discount = c.getDiscount();
		}
		return discount;
	}
}
