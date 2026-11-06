package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.FeePayment;
import com.klef.soa.service.FeePaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private FeePaymentService service;
	
	@GetMapping("/")
	public String demo() {
		return "Project is Running";
	}
	
	@PostMapping("/addpayment")
	public ResponseEntity<FeePayment> addPayment(@RequestBody FeePayment fp){
		FeePayment f = service.addPayment(fp);
		return ResponseEntity.status(201).body(f);
		
	}
	
	@GetMapping("/displayallpayments")
	public ResponseEntity<List<FeePayment>> displayAllPayments()
	{
		List<FeePayment> fp = service.displayAllPayments();
		return ResponseEntity.status(200).body(fp);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePayment(@PathVariable Long id){
		String msg = service.deletePayment(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/displayById/{id}")
	public ResponseEntity<?> displayById(@PathVariable Long id) {
	    FeePayment fp = service.displayById(id);
	    
	    if(fp != null)
	    {
	    	return ResponseEntity.status(200).body(fp);
	    }
	    else 
	    {
	    	return ResponseEntity.status(404).body("Payment Not Found");
	    }
	}
	
	@GetMapping("/displayByName/{name}")
	public ResponseEntity<List<FeePayment>> displayByName(@PathVariable String name) {
	    List<FeePayment> fp = service.displayByName(name);
	    return ResponseEntity.ok(fp);
	}
	
	@GetMapping("/displayByType/{type}")
	public ResponseEntity<?> displayByType(@PathVariable String type) {
	    List<FeePayment> fp = service.displayByType(type);
	  
	    if(fp != null)
	    {
	    	return ResponseEntity.status(200).body(fp);
	    }
	    else
	    {
	    	return ResponseEntity.status(404).body("Payment Type Not Found");
	    }
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePayments(@RequestBody FeePayment fp)
	{
		FeePayment f = service.updatePayment(fp);

		if (f != null)
		{
			return ResponseEntity.status(200).body(fp);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment ID Not Found");
		}
	}

}
