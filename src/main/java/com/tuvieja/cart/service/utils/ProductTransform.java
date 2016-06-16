package com.tuvieja.cart.service.utils;

import com.tuvieja.cart.dto.Image;
import com.tuvieja.cart.dto.Product;
import com.tuvieja.cart.dtoapi.GarbaImage;
import com.tuvieja.cart.dtoapi.GarbaProduct;

public class ProductTransform {

	public static GarbaProduct toGarba(Product p) {
		return new GarbaProduct(p.getGarbaId(), p.getDescription(), p.getPrice(), toGarba(p.getMainImage()));
	}

	public static Product fromGarba(GarbaProduct g) {
		return new Product(g.getId(), g.getDescription(), g.getPrice(), fromGarba(g.getMainImage()));
	}

	public static GarbaImage toGarba(Image i) {
		return new GarbaImage(i.getUrl(), i.getWidth());
	}

	public static Image fromGarba(GarbaImage g) {
		return new Image(g.getUrl(), g.getMaxWidth());
	}
}
