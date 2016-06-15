package com.tuvieja.cart.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuvieja.cart.dto.User;
import com.tuvieja.cart.service.CartService;


@RestController
@RequestMapping(value="/users")
public class UserController {
	private @Resource UserService us;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<User> fetchAll() {
        return users;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public String fetchOne (@PathVariable ("id") ObjectId id){
    	return response;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addUser (@RequestBody User user){
    	return response;
    }
    
    @RequestMapping (method = RequestMethod.PUT, value="{id}")
    public String editUser (@PathVariable ("id") ObjectId id, @RequestBody User user){
    	return response;
    }
    
    @RequestMapping (method = RequestMethod.DELETE, value="{id}")
    public String removeUser (@PathVariable ("id") ObjectId id){
    	return response;
    }
}
