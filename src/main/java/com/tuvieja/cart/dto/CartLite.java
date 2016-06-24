package com.tuvieja.cart.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;

public class CartLite {
	
	private ObjectId id;
	private String userId;
	private Date timeStamp;
	private String cartStatus;
	
	public CartLite (){
	}
	
	public CartLite (ObjectId id, String userId, Date timeStamp, String cartStatus){
		this.id = id;
		this.userId = userId;
		this.timeStamp = timeStamp;
		this.cartStatus = cartStatus;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		return sdf.format(timeStamp);
	}

	public String getUserId (){
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getId() {
		return id.toString();
	}
}
