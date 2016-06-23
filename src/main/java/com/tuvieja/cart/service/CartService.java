package com.tuvieja.cart.service;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.garbarino.gcommons.rest.exception.ResourceNotFoundException;
import com.tuvieja.cart.dao.CartDao;
import com.tuvieja.cart.dao.TransactionDao;
import com.tuvieja.cart.dto.Cart;
import com.tuvieja.cart.dto.CartItem;
import com.tuvieja.cart.dto.CartLite;
import com.tuvieja.cart.dto.Generic;
import com.tuvieja.cart.dto.PaymentInfo;
import com.tuvieja.cart.dto.Product;
import com.tuvieja.cart.service.utils.CartTransform;

@Service
public class CartService {
	private @Resource CartDao cd;
	private @Resource TransactionDao td;
	private @Resource ProductService ps;

	public Optional<Cart> fetchOne(String cartId) {
		return ofNullable(cd.fetchOne(cartId));
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
			Optional<Cart> c = fetchOne(cartId);

			if (c.isPresent()) {
				Cart cart = c.get();
				cart.removeAllFromCart(productId);
				cart.setCartStatus("cart updated");
				cd.editCart(cartId, cart);
			} else {
				throw new ResourceNotFoundException();
			}

		}
	}

	public void removeFromCart(String cartId, Generic doomedItem) {
		if (cd.itExists(cartId) && ps.itExists(doomedItem.getGarbaId())) {
			System.out.println("{CARTS} adding " + doomedItem.getQuantity() + " product (" + doomedItem.getGarbaId()
					+ ") @ CARTSERVICE");

			Optional<Cart> c = fetchOne(cartId);
			
			if (c.isPresent()){
				Cart cart = c.get();
				cart.removeSomeFromCart(doomedItem.getGarbaId(), doomedItem.getQuantity());
				cart.setCartStatus("cart updated");
				cd.editCart(cartId, cart);
			}else{
				throw new ResourceNotFoundException();
			}
		}
	}

	public void addToCart(String cartId, Generic newItem) {
		if (cd.itExists(cartId) && ps.itExists(newItem.getGarbaId())) {
			System.out.println("{CARTS} adding " + newItem.getQuantity() + " product (" + newItem.getGarbaId()
					+ ") @ CARTSERVICE");

			Optional<Cart> c = fetchOne(cartId);
			Product p = ps.fetchOne(newItem.getGarbaId());
			
			if (c.isPresent()){
				Cart cart = c.get();
				
				cart.addToCart(new CartItem(p, newItem.getQuantity()));
				cd.editCart(cartId, cart);
			}else{
				throw new ResourceNotFoundException();
			}
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
		Optional<Cart> c = fetchOne(cartId);

		if (c.isPresent()) {
			return CartTransform.toLite(c.get());
		} else {
			throw new ResourceNotFoundException();
		}
	}

	public Collection<CartLite> fetchAllLite() {
		return cd.fetchAll().stream().map(c -> CartTransform.toLite(c)).collect(Collectors.toList());
	}

	public void buyCart(String cartId, PaymentInfo payment) {
		if (cd.itExists(cartId)) {
			System.out.println("{CARTS} buying cart (" + cartId + ") @ CARTSERVICE");

			Cart c = cd.fetchOne(cartId);
			if (c.getUserId().equals(payment.getUserId())) {
				
				c.setCartStatus("bought cart");
				cd.editCart(cartId, c);
				
				payment.setDiscount(c.getDiscount());
				payment.setTotal(c.getTotal());
				td.createTransaction(payment);
			}
		}
	}
}
