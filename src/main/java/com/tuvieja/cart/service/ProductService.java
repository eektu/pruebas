package com.tuvieja.cart.service;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.tuvieja.cart.client.ProductClient;
import com.tuvieja.cart.dto.Image;
import com.tuvieja.cart.dto.Product;
import com.tuvieja.cart.dtoapi.GarbaProduct;
import com.tuvieja.cart.service.utils.ProductTransform;


@Service
public class ProductService {
	private @Resource ProductClient pc;
	
	public Collection<Product> fetchAll (){
    	return pc.getAllProducts().stream()
    			.map(p -> ProductTransform.fromGarba(p))
    			.collect(Collectors.toList());
	}
	
	public Product fetchOne (ObjectId productId){
		GarbaProduct gp = pc.getProduct(productId);
		return ProductTransform.fromGarba(gp);
	}
	
	public void deleteProduct (ObjectId productId){
		pc.removeProduct (productId);
	}
	
	public void editProduct (ObjectId productId, Product updatedProduct){
		pc.editProduct (productId, ProductTransform.toGarba(updatedProduct));
	}
	
	public void createProduct (Product newProduct){
		pc.createProduct(ProductTransform.toGarba(newProduct));
	}
}
