package com.tuvieja.cart.dao;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.garbarino.monga.dao.BaseDao;
import com.tuvieja.cart.dto.PaymentInfo;

public @Repository class TransactionDao extends BaseDao<PaymentInfo, String> {

	@Autowired
	public TransactionDao(Datastore ds) {
		super(PaymentInfo.class, ds);
	}

	public Collection<PaymentInfo> fetchByUser(String userId) {
		return getDs().find(PaymentInfo.class)
				.field("userId").equal(new ObjectId(userId))
				.asList();
	}

	public PaymentInfo fetchOne(String paymentId) {
		return getDs().find(PaymentInfo.class)
				.field("id").equal(new ObjectId(paymentId))
				.get();
	}

	public void createTransaction(PaymentInfo payment) {
		this.save(payment);
	}
}
