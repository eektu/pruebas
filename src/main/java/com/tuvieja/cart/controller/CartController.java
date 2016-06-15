package com.tuvieja.cart.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuvieja.cart.dto.Cart;
import com.tuvieja.cart.service.CartService;

@RestController
@RequestMapping(value = "/carts")
public class CartController {
	private @Resource CartService cs;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Cart> fetchAll() {
		return cs.fetchAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Cart fetchOne(@PathVariable("id") String cartId) {
		if (hasValidId(cartId)) {
			return cs.fetchOne(cartId);
		}
		return new Cart();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createCart(@RequestBody Cart cart) {
		if (hasUserId(cart)) {
			cs.createCart(cart);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public void editCart(@PathVariable("id") String cartId, @RequestBody Cart cart) {
		if (hasValidId(cartId) && hasUserId(cart)) {
			cs.editCart(cartId, cart);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void removeCart(@PathVariable("id") String cartId) {
		if (hasValidId (cartId)){
			cs.deleteCart(cartId);
		}
	}

	//ver como convertir todo a Optionals para mandar un 404
	private Boolean hasValidId(String cartId) {
		if (cartId != null && !"".equals(cartId)) {
			return true;
		}
		return false;
	}

	//ver como convertir todo a Optionals para mandar un 404
	private Boolean hasUserId(Cart cart) {
		if (cart.getUserId() != null && !"".equals(cart.getUserId())) {
			return true;
		}
		return false;
	}
}
