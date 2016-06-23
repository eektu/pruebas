package com.tuvieja.cart.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuvieja.cart.dto.User;
import com.tuvieja.cart.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	private @Resource UserService us;

	@RequestMapping(method = GET)
	public Collection<User> fetchAll() {
		System.out.println("{USERS} fetchAll en CONTROLLER");
		return us.fetchAll();
	}

	@RequestMapping(method = GET, value = "{id}")
	public User fetchOne(@PathVariable("id") String id) {
		System.out.println("{USERS} accessing user @ USERCONTROLLER");
		if (hasValidId(id)) {
			return us.fetchOne(id).get();
		}
		return new User();
	}

	@RequestMapping(method = POST)
	public void createUser(@RequestBody User user) {
		System.out.println("{USERS} creating user (" + user.getNickName() + ") @ USERCONTROLLER");
		us.createUser(user);
	}

	@RequestMapping(method = PUT, value = "{id}")
	public void editCart(@PathVariable("id") String id, @RequestBody User user) {
		if (hasValidId(id))
			us.editUser(id, user);
	}

	@RequestMapping(method = DELETE, value = "{id}")
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
