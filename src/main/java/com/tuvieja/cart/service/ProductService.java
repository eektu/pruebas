package com.tuvieja.cart.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tuvieja.cart.client.ProductClient;
import com.tuvieja.cart.dto.Product;


@Service
public class ProductService {
	private @Resource ProductClient pc;
	
	public Collection<Product> getAllProducts (){
    	return pc.getAllProducts();
	}
	
	public Product getProduct (String productId){
		return pc.getProduct (productId);
	}
	
	public void deleteProduct (String productId){
		pc.removeProduct (productId);
	}
	
	public void editProduct (String productId, Product updatedProduct){
		pc.editProduct (productId, updatedProduct);
	}
	
	public void createProduct (Product newProduct){
		pc.createProduct(newProduct);
	}
}
