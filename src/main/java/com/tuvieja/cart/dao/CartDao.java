package com.tuvieja.cart.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.garbarino.monga.dao.BaseDao;
import com.tuvieja.cart.dto.Cart;
public @Repository class CartDao extends BaseDao{
//public @Entity(noClassnameStored = true, value = "shopping_cart") class CartDao {
//	private @Id ObjectId id;
//	private @Property("brand") String brand;
//	
	public Cart fetchOne (String cartId){
		return null;
	}
	
	public Collection<Cart> fetchAll (){
		return null;
	}
	
	public void createCart (Cart cart){}
	
	public void editCart (String cartId, Cart cart){}
	
	public void deleteCart (String cartId){}
}
