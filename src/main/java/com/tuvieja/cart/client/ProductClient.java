package com.tuvieja.cart.client;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.garbarino.gcommons.rest.impl.RestConnector;
import com.garbarino.gcommons.serializers.Serializers;
import com.tuvieja.cart.dtoapi.GarbaProduct;

@Service
public class ProductClient {

	private @Resource RestConnector garbaRestConnector;
	
	public Collection<GarbaProduct> getAllProducts (){
    	String r = garbaRestConnector.prepareGet("products").execute().getBody();
    	return Serializers.json(GarbaProduct.class).listFromString(r);
	}
	
	public GarbaProduct getProduct (ObjectId productId){
		System.out.println("obteniendo producto: " + productId.toString());
		String r = garbaRestConnector.prepareGet("products").withParam("xid", productId.toString()).execute().getBody();
		return ((List<GarbaProduct>) Serializers.json(GarbaProduct.class).listFromString(r)).get(0);
	}
	
	public void removeProduct (ObjectId productId){
		//	!!! VER SI ESTA BIEN ARMADO EL REQUEST
		//garbaRestConnector.prepareDelete("products").withPathParam("xid", productId).execute();
	}
	
	public void editProduct (ObjectId productId, GarbaProduct updatedProduct){
		//	!!! VER SI ESTA BIEN ARMADO EL REQUEST
		String json = Serializers.json(GarbaProduct.class).toString(updatedProduct);
		//garbaRestConnector.preparePut("products").withPathParam("xid", productId).withBody(json);
	}
	
	public void createProduct (GarbaProduct newProduct){
		//	!!! VER SI ESTA BIEN ARMADO EL REQUEST
		String json = Serializers.json(GarbaProduct.class).toString(newProduct);
		//garbaRestConnector.preparePost("products").withBody(json);
	}
}
