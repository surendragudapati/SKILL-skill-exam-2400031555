package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.FeePayment;

@Repository
public interface FeePaymentRepository extends JpaRepository<FeePayment, Long> {
	 
	List<FeePayment> findByName(String name);
	
	
	List<FeePayment> findByType(String type);
	
}
