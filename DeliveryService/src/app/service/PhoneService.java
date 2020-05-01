package app.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.entity.PhoneNumberEntity;
import dto.PhoneNumber;

public interface PhoneService {

	PhoneNumber addPhone(String phone);

	Boolean deletePhone(String phone);

	PhoneNumber findPhone(String phone);

	PhoneNumber convertToDTO(PhoneNumberEntity phone);

}