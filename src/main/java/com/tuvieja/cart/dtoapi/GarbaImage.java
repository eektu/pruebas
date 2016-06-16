package com.tuvieja.cart.dtoapi;

public class GarbaImage {
	private int maxWidth;
	private String url;
	
	public GarbaImage (){
		this.maxWidth = 666;
		this.url = "http://meatspin-runner.com";
	}
	
	public GarbaImage (String url, int maxWidth){
		this.maxWidth = maxWidth;
		this.url = url;
	}
	
	public int getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
