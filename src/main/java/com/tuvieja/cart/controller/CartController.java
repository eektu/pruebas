package com.tuvieja.cart.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
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
	public Cart fetchOne(@PathVariable("id") ObjectId id) {
		if (hasValidId(id)) {
			return cs.fetchOne(id);
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
	public void editCart(@PathVariable("id") ObjectId id, @RequestBody Cart cart) {
		if (hasValidId(id) && hasUserId(cart)) {
			cs.editCart(id, cart);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteCart(@PathVariable("id") ObjectId id) {
		if (hasValidId (id)){
			cs.deleteCart(id);
		}
	}

	//ver como convertir todo a Optionals para mandar un 404
	private Boolean hasValidId(ObjectId id) {
		if (id != null && !"".equals(id)) {
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
