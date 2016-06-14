package com.tuvieja.cart.client;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.garbarino.gcommons.rest.impl.RestConnector;
import com.garbarino.gcommons.serializers.Serializers;
import com.tuvieja.cart.dto.Product;

@Service
public class ProductClient {

	private @Resource RestConnector garbaRestConnector;
	
	public Collection<Product> getAllProducts (){
    	String r = garbaRestConnector.prepareGet("products").execute().getBody();
    	return Serializers.json(Product.class).listFromString(r);
	}
	
	public Product getProduct (String productId){
		String r = garbaRestConnector.prepareGet("products").withParam("xid", productId).execute().getBody();
		return ((List<Product>) Serializers.json(Product.class).listFromString(r)).get(0);
	}
	
	public void removeProduct (String productId){
		//	!!! VER SI ESTA BIEN ARMADO EL REQUEST
		//garbaRestConnector.prepareDelete("products").withPathParam("xid", productId).execute();
	}
	
	public void editProduct (String productId, Product updatedProduct){
		//	!!! VER SI ESTA BIEN ARMADO EL REQUEST
		String json = Serializers.json(Product.class).toString(updatedProduct);
		//garbaRestConnector.preparePut("products").withPathParam("xid", productId).withBody(json);
	}
	
	public void createProduct (Product newProduct){
		//	!!! VER SI ESTA BIEN ARMADO EL REQUEST
		String json = Serializers.json(Product.class).toString(newProduct);
		//garbaRestConnector.preparePost("products").withBody(json);
	}
}
