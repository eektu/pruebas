package com.tuvieja.cart.dto;

public class Image {
	private int width;
	private String url;
	
	public Image (){
		width = 0;
		url = "http://meatspin.com";
	}
	
	public Image (String url, int width){
		this.url = url;
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
