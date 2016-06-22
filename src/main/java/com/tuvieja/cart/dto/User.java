package com.tuvieja.cart.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;

public @Entity(noClassnameStored = true, value = "Users") class User {
	
	private @Id ObjectId id;
	private @Indexed String nick_name;
	private @Property String name;
	private @Indexed String email;
	private @Property Date sign_up_date;
	private @Property Date last_seen;

	public User() {
		this.name = "default name";
		this.nick_name = "default nick";
		this.email = "default email";
	}

	public User(ObjectId id, String name, String nickName, String email) {
		this.id = id;
		this.name = name;
		this.nick_name = nickName;
		this.email = email;
	}
	
	public String getId() {
		return id.toString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNickName() {
		return nick_name;
	}

	public void setNickName(String nickName) {
		this.nick_name = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSignUpDate() {
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		return sdf.format(sign_up_date);
	}

	public void setSignUpDate(Date timeStamp) {
		this.sign_up_date = timeStamp;
	}

	public String getLastSeen() {
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		return sdf.format(last_seen);
	}

	public void setLastSeen(Date lastSeen) {
		this.last_seen = lastSeen;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
