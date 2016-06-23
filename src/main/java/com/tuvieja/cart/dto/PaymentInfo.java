package com.tuvieja.cart.dto;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

public @Entity(noClassnameStored = true, value = "Transactions") class PaymentInfo {

	private @Id ObjectId id;
	private @Indexed String userId;
	private String method;
	private int installments;
	private float total;
	private float discount;

	public PaymentInfo (){}
	public PaymentInfo (String userId, String method, int installments, float total, float discount){
		this.userId = userId;
		this.method = method;
		this.installments = installments;
		this.total = total;
		this.discount = discount;
	}

	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getInstallments() {
		return installments;
	}
	public void setInstallments(int installments) {
		this.installments = installments;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
}
