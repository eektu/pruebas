package com.tuvieja.cart.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.joda.time.DateTime;

import com.tuvieja.cart.dto.Cart;

public class IdGenerator {

	public static String getNewCartId(Cart cart) {
		String d = DateTime.now().toString();
		d += cart.getCartStatus();
		d += cart.getUserId();
		d += cart.getTimeStamp().toString();

		try {
			byte[] bytesOfMessage = d.getBytes("UTF-8");

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);
			
			d = thedigest.toString();
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
		
		return d;
	}
}
