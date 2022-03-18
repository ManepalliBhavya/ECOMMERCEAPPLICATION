package com.example.Jspdemo.controller;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.Jspdemo.model.Customer;
import com.example.Jspdemo.repository.CustomerRepository;

/**
 * Adding Spring MVC annotation before the class name.
 */
@Controller
public class CustomerController {
	/**
	 * Declare the previously created `CustomerRepository` after the class name.
	 */
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * The request mapping annotation lets spring MVC know which controller class
	 * method to call. This annotation takes two parameters called path/value and
	 * method. This way we could map them based on path as well as HTTP methods like
	 * , GET, POST, PUT and DETELE.
	 */
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String customerRegistration() {
		return "customer";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("customerForm") Customer customer, Map<String, Object> model) {

		// implement your own registration logic here...
		// for testing purpose:

		System.out.println("cusName: " + customer.getCusName());
		System.out.println("cusPhone: " + customer.getCusPhone());
		System.out.println("cusGendar: " + customer.getCusGender());
		System.out.println("cusCity: " + customer.getCusCity());
		customerRepository.save(customer);
		return "welcome";
	}
}