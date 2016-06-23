package com.tuvieja.cart.utils;

public class Discounter {

	private static int sumatoria (int value){
		if (value > 0){
			return value + sumatoria (value - 1);
		}
		return 0;
	}
	
	public static float getDiscount (float price, int cant){
		if (cant > 10){
			cant = 10;
		}
		return price * (sumatoria (cant - 1) / 10f);
	}
}
