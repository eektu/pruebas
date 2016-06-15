package com.tuvieja.cart.service;

import java.util.Collection;
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
	
	public Collection<Product> getAllProducts (){
    	return pc.getAllProducts().stream()
    			.map(p -> ProductTransform.fromGarba(p))
    			.collect(Collectors.toList());
	}
	
	public Product getProduct (String productId){
		GarbaProduct gp = pc.getProduct(productId);
		return ProductTransform.fromGarba(gp);
	}
	
	public void deleteProduct (String productId){
		pc.removeProduct (productId);
	}
	
	public void editProduct (String productId, Product updatedProduct){
		GarbaProduct gp = new GarbaProduct ();
		pc.editProduct (productId, updatedProduct);
	}
	
	public void createProduct (Product newProduct){
		pc.createProduct(newProduct);
	}
}
