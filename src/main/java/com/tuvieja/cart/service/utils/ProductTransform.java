package com.tuvieja.cart.service.utils;

import com.tuvieja.cart.dto.Product;
import com.tuvieja.cart.dtoapi.GarbaProduct;

public class ProductTransform {
	
	public static GarbaProduct toGarba(Product p) {
		return new GarbaProduct(p.getGarbaId(), p.getDescription(), p.getPrice(), p.getMainImage());
	}

	public static Product fromGarba(GarbaProduct g) {
		return new Product(g.getId(), g.getDescription(), g.getPrice(), g.getMainImage());
	}
}
