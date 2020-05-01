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
import org.springframework.web.bind.annotation.RestController;

import app.service.AddressService;
import app.service.ServiceDeliveryEngine;
import dto.Address;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired AddressService service;
	
	@GetMapping("get_adrs")
	public Address get(@RequestParam  Long id){
		return service.findAddress(id);
	}
	
	@PostMapping("add_adrs")
 	public Address set(@RequestBody @Valid Address address){
		return service.addAddress(address);
	} 
	
	@GetMapping("rm_adrs")
	public Boolean remove(@RequestParam Long id){
		return service.deleteAddress(Address.builder().id(id).build());
	}
	
	@PostMapping("find_by")
	public List<Address> getByTemplate(@RequestBody Address address){ // pseudo- GraphQL request
		return service.getBy(address);
	}
 }
