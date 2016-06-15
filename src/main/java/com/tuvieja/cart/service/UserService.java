package com.tuvieja.cart.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;

import com.tuvieja.cart.dao.UserDao;
import com.tuvieja.cart.dto.User;

/*
 * VERIFICACIONES:
 * - Ver que existan los registros a modificar
 * - Ver que existan las referencias (userId, productId, etc), llamar a los DAOs correspondientes 
 * 
 */

public class UserService {
	private @Resource UserDao ud;

	public User fetchOne(ObjectId id) {
		return ud.fetchOne(id);
	}

	public Collection<User> fetchAll() {
		return ud.fetchAll();
	}

	public void createUser(User user) {
		// verificar que exista el usuario, llamar al UserDao
		user.setSignUpDate(DateTime.now());
		user.setLastSeen(DateTime.now());
		ud.createUser(user);
	}

	public void userRecentlySeen(ObjectId id, User user) {
		// verificar que exista el user
		// verificar que solo cambie el lastSeen
		if (ud.exists(id)) {
			user.setLastSeen(DateTime.now());
			ud.editUser(id, user);
		}
	}

	public void editUser(ObjectId id, User user) {
		ud.editUser(id, user);
	}

	public void deleteUser(ObjectId id) {
		if (ud.exists(id)) {
			ud.deleteUser(id);
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
