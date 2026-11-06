package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.FeePayment;



public interface FeePaymentService {

	FeePayment addPayment(FeePayment vd);
	
	FeePayment updatePayment(FeePayment vd);
	
	String deletePayment(long feePaymentId);
	
	List<FeePayment> displayAllPayments();
	
	FeePayment displayById(long feePaymentId);

	List<FeePayment> displayByName(String name);
	
	List<FeePayment> displayByType(String type);
	
	
}
