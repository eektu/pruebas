package com.tuvieja.cart.dao;

import java.util.Collection;
import java.util.List;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.garbarino.monga.dao.BaseDao;
import com.tuvieja.cart.dto.User;

public @Repository class UserDao extends BaseDao<User, String> {

	@Autowired
	public UserDao(Datastore ds) {
		super(User.class, ds);
	}
	
	public boolean exists(ObjectId id) {
		if (fetchOne(id) != null) {
			return true;
		}
		return false;
	}

	public User fetchOne(ObjectId id) {
		return getDs().find(User.class)
				.field("id").equalIgnoreCase(id)
				.get();
	}

	public void createUser(User user) {
		this.save(user);
	}

	public void editUser(ObjectId id, User user) {
		// pido usuario a la DB
		User updatedUser = fetchOne(id);
		// lo edito con los datos que yo quiero que el usuario/plataforma pueda
		updatedUser.setEmail(user.getEmail());
		updatedUser.setLastSeen(DateTime.now());
		updatedUser.setNickName(user.getNickName());
		// persistir
		getDs().save(updatedUser);
	}

	public void deleteUser(ObjectId id) {
		User doomedUser = fetchOne(id);
		getDs().delete(doomedUser);
	}
}
