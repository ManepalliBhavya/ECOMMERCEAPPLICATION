package com.example.Jspdemo.service;

/**
 * Importing all the packages whatever needed in this class
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jspdemo.repository.CustomerRepository;

/**
 * Service Components are the class file which contains @Service annotation.
 * These class files are used to write business logic in a different layer,
 * separated from @Controller class file.
 */
@Service
public class CustomerService {
	/**
	 * Declare the customer repository.
	 */
	@Autowired
	private CustomerRepository customerRepository;

	//Generate parameterless constructor
	public CustomerService() {

	}

	//Generate parameterized constructor
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

}
