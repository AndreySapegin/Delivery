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
import dto.Delivery;

@Controller
@RequestMapping("/deliv")
public class DeliveryController {

	@Autowired ServiceDeliveryEngine service;
	
	@GetMapping("get_dlry")
	public ResponseEntity<Delivery> get(@RequestParam  Long id){
		return service.getDelivery(id);
	}

	@GetMapping("rm_dlry")
	public ResponseEntity<Boolean> remove(@RequestParam Long id){
		return service.removeDelivery(id);
	}

	@PostMapping("add_dlry")
 	public ResponseEntity<Boolean> set(@RequestBody @Valid Delivery delivery){
		return service.setDelivery(delivery);
	} 
		
	@PostMapping("find_by")
	public ResponseEntity<List<Delivery>> getByTemplate(@RequestBody Delivery delivery){ // pseudo- GraphQL request
		return service.getBy(delivery);
	}
}
