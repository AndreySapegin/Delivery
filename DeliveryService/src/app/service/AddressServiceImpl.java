package app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.entity.AddressEntity;
import app.repository.AddressRepository;
import app.repository.CustomerRepository;
import app.repository.PersonRepository;
import dto.Address;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AddressServiceImpl implements AddressService {
	
	@Autowired ModelMapper modelMapper;
	@Autowired AddressRepository adsRepo;
	@Autowired CustomerRepository custRepo;
	@Autowired PersonRepository persRepo; 
	
	@Override
	@Transactional
	public Address addAddress(Address address) {
		var addressEntity = modelMapper.map(address,AddressEntity.class);
		adsRepo.findById(address.getId()).ifPresent(a -> {throw new RuntimeException("Address with ID "+ a.getId() + "already exist in database");});
		adsRepo.save(addressEntity);
		return convertToDTO(addressEntity);
	}
	
	@Override
	@Transactional
	public Boolean deleteAddress(Address address) {
		var addressEntity = adsRepo.findById(address.getId()).orElseThrow(() -> {throw new RuntimeException("Address with ID " + address.getId() + " not found");});
		if (custRepo.isAddress(address.getId()) || persRepo.isAddress(address.getId())) return false; //not orphan
		adsRepo.delete(addressEntity);
		return true;
	}

	@Override
	public Address findAddress(Long id) {
		var addressEntity = adsRepo.findById(id).orElseThrow(() -> {throw new RuntimeException("Address with ID "+ id +" not found");});
		return convertToDTO(addressEntity);
	}

	@Override
	public List<Address> getBy(Address address) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Address convertToDTO(AddressEntity address) {
		return modelMapper.map(address, Address.class);
	}


}
