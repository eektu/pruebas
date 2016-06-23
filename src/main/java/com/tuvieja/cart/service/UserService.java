package com.tuvieja.cart.service;

import static java.util.Optional.ofNullable;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tuvieja.cart.dao.UserDao;
import com.tuvieja.cart.dto.User;

@Service
public class UserService {
	private @Resource UserDao ud;

	public Optional<User> fetchOne(String userId) {
		return ofNullable(ud.fetchOne(userId));
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
		if (itExists(id)) {
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
		if (itExists(id)) {
			ud.deleteUser(id);
		}
	}
	
	public boolean itExists (String userId){
		if (fetchOne (userId).isPresent()){
			return true;
		}
		return false;
	}
}
