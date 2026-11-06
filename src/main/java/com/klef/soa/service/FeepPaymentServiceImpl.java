package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.FeePayment;
import com.klef.soa.repository.FeePaymentRepository;

@Service
public class FeepPaymentServiceImpl implements FeePaymentService{
	
	@Autowired
	private FeePaymentRepository repo;

	@Override
	public FeePayment addPayment(FeePayment vd) {
		return repo.save(vd);
	}

	@Override
	public FeePayment updatePayment(FeePayment f) {
		Optional<FeePayment> optional = repo.findById(f.getFeePaymentId());
		
		if(optional.isPresent()) {
			
			FeePayment fp = optional.get();
			fp.setName(f.getName());
			fp.setType(f.getType());
			fp.setLocation(f.getLocation());
			fp.setStatus(f.getStatus());
			
			return repo.save(fp);
			
		}
		else {
			
			return null;
		}
	
	}

	@Override
	public String deletePayment(long feePaymentId) {
		boolean flag = repo.existsById(feePaymentId);
		if(flag) {
			repo.deleteById(feePaymentId);
			return "Payment Deleted";
		}
		else {
			return "Payment not Found";
		}
		
	}

	@Override
	public List<FeePayment> displayAllPayments() {
		return repo.findAll();
	}

	@Override
	public FeePayment displayById(long feePaymentId) {
		return repo.findById(feePaymentId).orElse(null);
	}

	@Override
	public List<FeePayment> displayByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public List<FeePayment> displayByType(String type) {
		return repo.findByType(type);
	}
	
	

}
