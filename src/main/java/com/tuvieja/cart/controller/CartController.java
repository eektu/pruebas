package com.tuvieja.cart.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garbarino.gcommons.rest.BaseController;
import com.tuvieja.cart.dto.Cart;
import com.tuvieja.cart.dto.CartItem;
import com.tuvieja.cart.dto.CartLite;
import com.tuvieja.cart.dto.Generic;
import com.tuvieja.cart.dto.PaymentInfo;
import com.tuvieja.cart.service.CartService;

@RestController
@RequestMapping(value = "/carts")
public class CartController extends BaseController{
	private @Resource CartService cs;

	@RequestMapping(method = GET)
	public Collection<CartLite> fetchAllLite() {
		return cs.fetchAllLite();
	}

	@RequestMapping(method = GET, value = "{id}")
	public CartLite fetchOneLite(@PathVariable("id") String cartId) {
		if (hasValidId(cartId)) {
			return cs.fetchOneLite(cartId);
		}
		return new CartLite();
	}

	@RequestMapping(method = POST)
	public void createCart(@RequestBody Cart cart) {
		if (hasUserId(cart)) {
			cs.createCart(cart);
		}
	}

	@RequestMapping(method = PUT, value = "{id}")
	public void editCart(@PathVariable("id") String cartId, @RequestBody Cart cart) {
		if (hasValidId(cartId) && hasUserId(cart)) {
			cs.editCart(cartId, cart);
		}
	}
	
	@RequestMapping(method = DELETE, value = "{id}")
	public void deleteCart(@PathVariable("id") String cartId) {
		if (hasValidId(cartId)) {
			cs.deleteCart(cartId);
		}
	}
	
	@RequestMapping(method = GET, value = "{id}/discount")
	public float getCartDiscount(@PathVariable("id") String cartId) {
		System.out.println ("{CARTS} calculating (" + cartId + ") discount @ CARTCONTROLLER");
		return cs.fetchOne(cartId).get().getDiscount();
	}
	
	@RequestMapping(method = POST, value = "{id}/buy")
	public void buyCart(@PathVariable("id") String cartId, @RequestBody PaymentInfo payment) {
		System.out.println("{CARTS} buying cart (" + cartId + ") " + payment.getMethod() + ", " + payment.getInstallments() + " cuotas @ CARTCONTROLLER");
		if (hasValidId(cartId)) {
			cs.buyCart(cartId, payment);
		}
	}
	
	@RequestMapping(method = GET, value = "{id}/items")
	public Collection<CartItem> fetchAllItems(@PathVariable("id") String cartId) {
		System.out.println ("{CARTS} fetching all items in cart (" + cartId + ") @ CARTCONTROLLER");
		return cs.fetchAllItems(cartId);
	}
	
	@RequestMapping(method = POST, value = "{id}/items")
	public void addItemToCart(@PathVariable("id") String cartId, @RequestBody Generic newItem) {
		System.out.println("{CARTS} adding " + newItem.getQuantity() + " product (" + newItem.getGarbaId() + ") @ CARTCONTROLLER");
		//a ver si explota sin serializar..
		if (hasValidId(cartId) && hasValidId(newItem.getGarbaId()) && newItem.getQuantity() > 0) {
			cs.addToCart(cartId, newItem);
		}
	}
	
	@RequestMapping(method = PUT, value = "{id}/items")
	public void updateItemInCart(@PathVariable("id") String cartId, @RequestBody Generic updateItem) {
		System.out.println("{CARTS} updating " + updateItem.getQuantity() + " product (" + updateItem.getGarbaId() + ") @ CARTCONTROLLER");
		if (hasValidId(cartId) && hasValidId(updateItem.getGarbaId())) {
			cs.updateQuantity(cartId, updateItem);
		}
	}
	
	@RequestMapping(method = DELETE, value = "{id}/items/{productid}")
	public void removeItemFromCart(@PathVariable("id") String cartId, @PathVariable("productid") String productId) {
		System.out.println("{CARTS} deleting product (" + productId + ") @ CARTCONTROLLER");
		//a ver si explota sin serializar..
		if (hasValidId(cartId) && hasValidId(productId)) {
			cs.deleteFromCart(cartId, productId);
		}
	}

	// ver como convertir todo a Optionals para mandar un 404
	private boolean hasValidId(String id) {
		if (id != null && !"".equals(id)) {
			return true;
		}
		return false;
	}

	// ver como convertir todo a Optionals para mandar un 404
	private boolean hasUserId(Cart cart) {
		if (cart.getUserId() != null && !"".equals(cart.getUserId())) {
			return true;
		}
		return false;
	}
}
