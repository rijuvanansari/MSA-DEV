package com.soft.infogain.component;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.soft.infogain.model.Customer;
import com.soft.infogain.model.CustomerRespository;

@Component 
@Lazy
public class CustomerRegistrar {
	
	CustomerRespository customerRespository;
	Sender sender;
	
	@Autowired
	CustomerRegistrar(CustomerRespository customerRespository, Sender sender){
		this.customerRespository = customerRespository;
		this.sender = sender;
	}
	
	public Customer register(Customer customer){
		Optional<Customer> existingCustomer = customerRespository.findByName(customer.getName());
		if (existingCustomer.isPresent()){
			throw new RuntimeException("is already exists");
		} else {
			customerRespository.save(customer); 
			sender.send(customer.getEmail());
		} 
		return customer;
	}
}
