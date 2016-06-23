package com.tuvieja.cart.dao;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.garbarino.monga.dao.BaseDao;
import com.tuvieja.cart.dto.Cart;
import com.tuvieja.cart.dto.CartItem;

public @Repository class CartDao extends BaseDao<Cart, String> {

	@Autowired
	public CartDao(Datastore ds) {
		super(Cart.class, ds);
	}

	public Collection<CartItem> fetchAllItems(String cartId) {
		return ((Cart) getDs().find(Cart.class)
				.field("id").equal(new ObjectId(cartId))
				.get())
				.getCartItems();
	}

	// ver si funciona
	public Collection<Cart> fetchByStatus(String id, String status) {
		return getDs().find(Cart.class)
				.field("id").equal(new ObjectId(id))
				.field("cart_status").equalIgnoreCase(status)
				.asList();
	}

	public Cart fetchOne(String id) {
		return getDs().find(Cart.class)
				.field("id").equal(new ObjectId(id))
				.get();
	}

	public void createCart(Cart cart) {
		this.save(cart);
	}

	public void editCart(String id, Cart cart) {
		// pido carrito a la DB
		Cart updatedCart = fetchOne(id);
		// lo edito con los datos que yo quiero que el usuario/plataforma pueda
		updatedCart.setCartItems(cart.getCartItems());
		updatedCart.setCartStatus(cart.getCartStatus());
		// persistir
		getDs().save(updatedCart);
	}

	public void deleteCart(String id) {
		Cart doomedCart = fetchOne(id);
		getDs().delete(doomedCart);
	}

	public boolean itExists(String id) {
		if (fetchOne(id) != null) {
			return true;
		}
		return false;
	}
}
