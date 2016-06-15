package com.tuvieja.cart.dao;

import java.util.Collection;

import org.bson.types.ObjectId;
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

	public boolean exists(ObjectId id) {
		if (fetchOne(id) != null) {
			System.out.println(fetchOne(id).getUserId());
			return true;
		}
		return false;
	}

	public Collection<Cart> fetchSome(String userId, String status) {
		return getDs().find(Cart.class)
				.field("userId").equalIgnoreCase(userId)
				.field("cart_status").equalIgnoreCase(status)
				.asList();
	}

	public Cart fetchOne(ObjectId id) {
		return getDs().find(Cart.class).field("id").equalIgnoreCase(id).get();
	}

	public void createCart(Cart cart) {
		this.save(cart);
	}

	public void editCart(ObjectId id, Cart cart) {
		// pido carrito a la DB
		Cart updatedCart = fetchOne(id);
		// lo edito con los datos que yo quiero que el usuario/plataforma pueda
		updatedCart.setCartStatus("updated cart");
		updatedCart.setProducts(cart.getCartProducts());
		// persistir
		getDs().save(updatedCart);
	}

	public void deleteCart(ObjectId id) {
		Cart doomedCart = fetchOne(id);
		getDs().delete(doomedCart);
	}
}
