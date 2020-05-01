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
import dto.Employee;

@Controller
@RequestMapping("/team")
public class EmployeeController {

	@Autowired ServiceDeliveryEngine service;
	
	@GetMapping("get_empl")
	public ResponseEntity<Employee> get(@RequestParam Long id){
		return service.getEmployee(id);
	}
	
	@GetMapping("rm_empl")
	public ResponseEntity<Boolean> remove(@RequestParam Long id){
		return service.removeEmployee(); 
	}
	
	@PostMapping("add_empl")
	public ResponseEntity<Boolean> add(@RequestBody @Valid Employee employee){
		return service.addEmployee(employee);
	}
	@PostMapping("find_by")
	public ResponseEntity<List<Employee>> findBy(@RequestBody Employee employee) { // pseudo- GraphQL request
		return service.findByEmployee((Employee) employee);
	}
	
}
