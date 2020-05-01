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
import dto.Person;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired ServiceDeliveryEngine service;
	
	@GetMapping("get_prsn")
	public ResponseEntity<Person> get(@RequestParam Long id){
		return service.getPerson(id);
	}
	
	@GetMapping("rm_prsn")
	public ResponseEntity<Boolean> remove(@RequestParam Long id){
		return service.removePerson(); 
	}
	
	@PostMapping("add_prsn")
	public ResponseEntity<Boolean> add(@RequestBody @Valid Person person){
		return service.addPerson(person);
	}
	
	@PostMapping("find_by")
	public ResponseEntity<List<Person>> findBy(@RequestBody Person person) {  // pseudo- GraphQL request
		return service.findBy(person);
	}
}
