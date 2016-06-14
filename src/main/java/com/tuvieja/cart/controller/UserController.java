package com.tuvieja.cart.controller;

import org.springframework.web.bind.annotation.RestController;

import com.garbarino.gcommons.rest.impl.RestConnector;
import com.garbarino.gcommons.serializers.Serializers;
import com.tuvieja.cart.dto.User;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value="/users")
public class UserController {
	private ArrayList <User> users;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<User> fetchAll() {
    	//RestConnector c = new RestConnector("api-prod.garbarino.com","");
    	//Serializers.json(User.class).toString()
    	//c.prepareGet("users").execute().getBody()
        return users;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public String fetchOne (@PathVariable ("id") String userId){
    	String response = "";
    	response = "usuario loco: " + userId;
    	return response;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addUser (@RequestBody User user){
    	String response = "";
    	//String r = c.preparePost("users").withBody("").execute().getBody();
    	//Serializers.json(User.class).toString()
    	return response;
    }
    
    @RequestMapping (method = RequestMethod.PUT, value="{id}")
    public String editUser (@PathVariable ("id") String userId, @RequestBody User user){
    	String response = "";
    	return response;
    }
    
    @RequestMapping (method = RequestMethod.DELETE, value="{id}")
    public String removeUser (@PathVariable ("id") String userId){
    	String response = "";
    	return response;
    }
}
