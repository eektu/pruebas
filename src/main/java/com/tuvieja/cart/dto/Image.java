package com.tuvieja.cart.dto;

public class Image {
	private String url;
	
	public Image (){
		url = "meatspin squared";
	}
	
	public Image (String url){
		this.url = url;
	}
	
	public String getURL (){
		return url;
	}
}
