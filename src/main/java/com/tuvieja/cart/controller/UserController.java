package com.tuvieja.cart.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuvieja.cart.dto.User;
import com.tuvieja.cart.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	private @Resource UserService us;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<User> fetchAll() {
		System.out.println("{USERS} fetchAll en CONTROLLER");
		return us.fetchAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User fetchOne(@PathVariable("id") String id) {
		System.out.println("{USERS} accessing user @ USERCONTROLLER");
		if (hasValidId(id)) {
			return us.fetchOne(id);
		}
		return new User();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		System.out.println("{USERS} creating user (" + user.getNickName() + ") @ USERCONTROLLER");
		us.createUser(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public void editCart(@PathVariable("id") String id, @RequestBody User user) {
		if (hasValidId(id))
			us.editUser(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteUser(@PathVariable("id") String id) {
		if (hasValidId(id))
			us.deleteUser(id);
	}

	// ver como convertir todo a Optionals para mandar un 404
	private Boolean hasValidId(String id) {
		if (id != null && !"".equals(id))
			return true;
		return false;
	}
}
