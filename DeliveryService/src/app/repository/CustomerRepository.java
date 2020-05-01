package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	@Query("SELECT CASE WHEN COUNT(phn.phone) = 0 THEN false ELSE true END FROM #{#entityName} c JOIN c.commonPhone phn WHERE phn.phone = ?1")
	public Boolean isPhone(String phone);

	@Query("SELECT CASE WHEN COUNT(a.id) = 0 THEN false ELSE true END FROM #{#entityName} c JOIN c.address a WHERE a.id = ?1")
	public Boolean isAddress(Long id);
	
}
