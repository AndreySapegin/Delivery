package app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import app.entity.AddressEntity;
import dto.Address;

public interface AddressService {

	Address addAddress(Address address);

	Boolean deleteAddress(Address address);

	Address findAddress(Long id);

	Address convertToDTO(AddressEntity address);

	List<Address> getBy(Address address);

}