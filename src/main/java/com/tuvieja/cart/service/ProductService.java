package com.tuvieja.cart.service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tuvieja.cart.client.ProductClient;
import com.tuvieja.cart.dto.Product;
import com.tuvieja.cart.dtoapi.GarbaProduct;
import com.tuvieja.cart.service.utils.ProductTransform;


@Service
public class ProductService {
	private @Resource ProductClient pc;
	
	public Collection<Product> fetchAll (){
    	return pc.fetchAll().stream()
    			.map(p -> ProductTransform.fromGarba(p))
    			.collect(Collectors.toList());
	}
	
	public Product fetchOne (String productId){
		GarbaProduct gp = pc.fetchOne(productId).get();
		return ProductTransform.fromGarba(gp);
	}
	
	public boolean itExists (String productId){
		return pc.itExists (productId);
	}
}
