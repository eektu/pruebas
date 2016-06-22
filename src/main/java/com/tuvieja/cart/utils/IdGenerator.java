package com.tuvieja.cart.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.tuvieja.cart.dto.Cart;
import com.tuvieja.cart.dto.User;

public class IdGenerator {

	public static String getNewUserId(User user){
		String d = getNow();
		d += user.getEmail();
		d += user.getNickName();
		d += user.getName();
		d += user.getSignUpDate();
		
		return doHash (d);
	}
	
	public static String getNewCartId(Cart cart) {
		String d = getNow();
		d += cart.getUserId();
		d += cart.getTimeStamp();
		
		return doHash (d);
	}
	
	private static String getNow (){
		Date now = new Date ();
		return now.toString();
	}
	
	//DO.. DO HASH.. 
	private static String doHash (String toHash){
		try {
			byte[] bytesOfMessage = toHash.getBytes("UTF-8");

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);
			
			toHash = thedigest.toString();
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
		
		return toHash;
	}
}
