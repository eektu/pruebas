package com.tuvieja.cart.service.utils;

import com.tuvieja.cart.dto.Cart;
import com.tuvieja.cart.dto.CartLite;

public class CartTransform {

	public static CartLite toLite(Cart c) {
		return new CartLite(c.getId(), c.getUserId(), c.getTimeStamp(), c.getCartStatus());
	}
}
