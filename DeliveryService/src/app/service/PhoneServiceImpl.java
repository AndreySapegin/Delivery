package app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.entity.PhoneNumberEntity;
import app.repository.CustomerRepository;
import app.repository.PersonRepository;
import app.repository.PhoneNumberRepository;
import dto.PhoneNumber;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PhoneServiceImpl implements PhoneService {

	@Autowired PhoneNumberRepository phnRepo;
	@Autowired CustomerRepository customerRepo;
	@Autowired PersonRepository personRepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PhoneNumber addPhone(String phone) {
		phnRepo.findById(phone).ifPresent( p -> {throw new RuntimeException("Phone number "+ p.getPhone()+" already exist in database");});
		var phoneEntity = new PhoneNumberEntity(phone);
		phnRepo.save(phoneEntity);
		return convertToDTO(phoneEntity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deletePhone(String phone) {
		var phoneEntity = phnRepo.findById(phone).orElseThrow();
		if (customerRepo.isPhone(phone) || personRepo.isPhone(phone)) return false; // not orphan
		phnRepo.delete(phoneEntity);
		return true;
	}
	
	@Override
	public PhoneNumber findPhone(String phone) {
		var phnEntity = phnRepo.findById(phone).orElseThrow(() -> {throw new RuntimeException("Phone number "+phone +" not found");});
		return convertToDTO(phnEntity);
	}
	
	@Override
	public PhoneNumber convertToDTO(PhoneNumberEntity phone) {
		return new PhoneNumber(phone.getPhone());
	}
}
