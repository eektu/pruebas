package com.tuvieja.cart.dao;

import java.util.Date;

import org.bson.types.ObjectId;
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

	public boolean exists(String id) {
		if (fetchOne(id) != null) {
			return true;
		}
		return false;
	}

	public boolean isTaken(User user) {
		if (isNickNameTaken(user.getNickName()) || isEmailTaken(user.getEmail())) {
			System.out.println("{USERDAO} the user already exists");
			return true;
		}
		return false;
	}

	public boolean isNickNameTaken(String nickName) {
		if (fetchByNickName(nickName) != null) {
			System.out.println("{USERDAO} nickname (" + nickName + ") is taken");
			return true;
		}
		return false;
	}

	public boolean isEmailTaken(String email) {
		if (fetchByEmail(email) != null) {
			System.out.println("{USERDAO} email (" + email + ") is taken");
			return true;
		}
		return false;
	}

	public User fetchOne(String id) {
		return getDs().find(User.class).field("id").equal(new ObjectId(id)).get();
	}

	public User fetchByEmail(String email) {
		return getDs().find(User.class).field("email").equalIgnoreCase(email).get();
	}

	public User fetchByNickName(String nickName) {
		return getDs().find(User.class).field("nick_name").equalIgnoreCase(nickName).get();
	}

	public void createUser(User user) {
		System.out.println("{USERDAO} creating user: " + user.getNickName());
		this.save(user);
	}

	public void editUser(String id, User user) {
		// pido usuario a la DB
		User updatedUser = fetchOne(id);
		// lo edito con los datos que yo quiero que el usuario/plataforma pueda
		updatedUser.setEmail(user.getEmail());
		updatedUser.setLastSeen(new Date());
		updatedUser.setNickName(user.getNickName());

		System.out.println("{USERDAO} updating user (" + user.getNickName() + ") data");
		// persistir
		getDs().save(updatedUser);
	}

	public void deleteUser(String id) {
		User doomedUser = fetchOne(id);
		System.out.println("{USERDAO} deleting user: " + doomedUser.getNickName());
		getDs().delete(doomedUser);
	}
}
