package com.tuvieja.cart.client;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.garbarino.gcommons.rest.impl.RestConnector;
import com.garbarino.gcommons.serializers.Serializers;
import com.tuvieja.cart.dtoapi.GarbaProduct;

@Service
public class ProductClient {

	private @Resource RestConnector garbaRestConnector;
	
	public Collection<GarbaProduct> fetchAll (){
    	String r = garbaRestConnector.prepareGet("products").execute().getBody();
    	return Serializers.json(GarbaProduct.class).listFromString(r);
	}
	
	public GarbaProduct fetchOne (String productId){
		System.out.println("obteniendo producto: " + productId);
		String r = garbaRestConnector.prepareGet("products/" + productId)
				.execute()
				.getBody();
		//System.out.println(r);
		return Serializers.json(GarbaProduct.class).fromString(r);
	}
}
