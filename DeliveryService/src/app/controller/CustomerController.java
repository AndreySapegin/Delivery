package app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.service.ServiceDeliveryEngine;
import dto.Customer;

@Controller
@RequestMapping("/cusom")
public class CustomerController {

	@Autowired ServiceDeliveryEngine service;
	
	@GetMapping("get_cutmr")
	public ResponseEntity<Customer> get(@RequestParam Long id){
		return service.getCustomer(id);
	}
	
	@GetMapping("rm_cutmr")
	public ResponseEntity<Boolean> remove(@RequestParam Long id){
		return service.removeCustomer(); 
	}
	
	@PostMapping("add_cutmr")
	public ResponseEntity<Boolean> add(@RequestBody @Valid Customer customer){
		return service.addCustomer(customer);
	}
	@PostMapping("find_by")
	public ResponseEntity<List<Customer>> findBy(@RequestBody Customer customer) { // pseudo- GraphQL request
		return service.findBy(customer);
	}
}
