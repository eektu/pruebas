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
	private @Indexed @Property("nick_name") String nickName;
	private @Indexed @Property("email") String email;
	private @Property("name") String name;
	private @Property("sign_up_date") Date signUpDate;
	private @Property("last_seen") Date lastSeen;

	public User() {
		this.name = "default name";
		this.nickName = "default nick";
		this.email = "default email";
	}

	public User(ObjectId id, String name, String nickName, String email) {
		this.id = id;
		this.name = name;
		this.nickName = nickName;
		this.email = email;
	}
	
	public String getId() {
		return id.toString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSignUpDate() {
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		return sdf.format(signUpDate);
	}

	public void setSignUpDate(Date timeStamp) {
		this.signUpDate = timeStamp;
	}

	public String getLastSeen() {
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		return sdf.format(lastSeen);
	}

	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
