package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.service.PhoneService;
import dto.PhoneNumber;
import dto.validation.PhoneValid;

@RestController
@RequestMapping("/phone")
@Validated
public class PhoneNumberController {

	@Autowired PhoneService service;
	
	@GetMapping("add")
	public PhoneNumber addPhone(@RequestParam @PhoneValid String phone) {
		return service.addPhone(phone);
	}
	
	@GetMapping("{phone}")
	public PhoneNumber get(@PathVariable @PhoneValid String phone) {
		return service.findPhone(phone);
	}
	
	@DeleteMapping("{phone}")
	public Boolean delete(@PathVariable @PhoneValid String phone) {
		return service.deletePhone(phone);
	}
}
