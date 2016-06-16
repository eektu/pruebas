package com.tuvieja.cart.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuvieja.cart.dto.Image;
import com.tuvieja.cart.dto.Product;
import com.tuvieja.cart.service.ProductService;



@RestController
@RequestMapping(value="/products")
public class ProductController {
	private @Resource ProductService ps;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Product> fetchAll() {
    	return ps.fetchAll();
    }
    
    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public Product fetchOne (@PathVariable ("id") ObjectId productId){
    	return ps.fetchOne(productId);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void createProduct (@RequestBody Product product){
    	ps.createProduct (product);
    }
    
    @RequestMapping (method = RequestMethod.PUT, value="{id}")
    public void editProduct (@PathVariable ("id") ObjectId productId, @RequestBody Product product){
    	ps.editProduct(productId, product);
    }
    
    @RequestMapping (method = RequestMethod.DELETE, value="{id}")
    public void deleteProduct (@PathVariable ("id") ObjectId productId){
    	ps.deleteProduct(productId);
    }
}
