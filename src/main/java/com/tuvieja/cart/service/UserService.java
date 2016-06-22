package com.tuvieja.cart.service;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import com.tuvieja.cart.dao.UserDao;
import com.tuvieja.cart.dto.User;

public class UserService {
	private @Resource UserDao ud;

	public User fetchOne(String id) {
		return ud.fetchOne(id);
	}

	public Collection<User> fetchAll() {
		System.out.println("{USERS} fetchAll @ SERVICE");
		return ud.fetchAll();
	}

	public void createUser(User user) {
		if (!ud.isTaken(user)) {
			System.out.println("{USERS} 'creating user (" + user.getNickName() + ")' @ SERVICE");
			user.setSignUpDate(new Date());
			user.setLastSeen(new Date());
			ud.createUser(user);
		}
	}

	public void userRecentlySeen(String id, User user) {
		System.out.println("{USERS} '(" + user.getNickName() + ") recently seen' @ SERVICE");
		if (ud.exists(id)) {
			user.setLastSeen(new Date());
			ud.editUser(id, user);
		}
	}

	public void editUser(String id, User user) {
		System.out.println("{USERS} edited user (" + user.getNickName() + ") @ SERVICE");
		ud.editUser(id, user);
	}

	public void deleteUser(String id) {
		System.out.println("{USERS} deleted user @ SERVICE");
		if (ud.exists(id)) {
			ud.deleteUser(id);
		}
	}
}
