package com.tuvieja.cart.dto;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;

public @Entity(noClassnameStored = true, value = "Users") class User {
	
	private @Id ObjectId id;
	private @Indexed String userId;
	private @Indexed String nickName;
	private @Property String name;
	private @Indexed String email;
	private @Property DateTime timeStamp;
	private @Property DateTime lastSeen;

	public User() {
		userId = "";
		name = "";
	}

	public User(String userId, String name) {
		this.userId = userId;
		this.name = name;
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

	public DateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(DateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public DateTime getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(DateTime lastSeen) {
		this.lastSeen = lastSeen;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}
}
