package com.tuvieja.cart.dto;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;

public @Entity(noClassnameStored = true, value = "Users") class User {
	
	private @Id ObjectId id;
	private @Indexed String nickName;
	private @Property String name;
	private @Indexed String email;
	private @Property DateTime signUpDate;
	private @Property DateTime lastSeen;

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

	public ObjectId getId() {
		return id;
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

	public DateTime getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(DateTime timeStamp) {
		this.signUpDate = timeStamp;
	}

	public DateTime getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(DateTime lastSeen) {
		this.lastSeen = lastSeen;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
