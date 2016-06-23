package com.tuvieja.cart.client;

import static java.util.Optional.ofNullable;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.garbarino.gcommons.rest.impl.RestConnector;
import com.garbarino.gcommons.serializers.Serializers;
import com.tuvieja.cart.dtoapi.GarbaProduct;

@Service
public class ProductClient {

	private @Resource RestConnector garbaRestConnector;

	public Collection<GarbaProduct> fetchAll() {
		String r = garbaRestConnector.prepareGet("products").execute().getBody();
		return Serializers.json(GarbaProduct.class).listFromString(r);
	}

	public Optional<GarbaProduct> fetchOne(String productId) {
		System.out.println("{PRODUCTS} fetching product (" + productId + ") @ PRODUCTCLIENT");

		String r = garbaRestConnector.prepareGet("products/" + productId).execute().getBody();
		return ofNullable(Serializers.json(GarbaProduct.class).fromString(r));
	}

	public boolean itExists(String productId) {
		if (fetchOne(productId).isPresent()) {
			return true;
		}
		return false;
	}
}
