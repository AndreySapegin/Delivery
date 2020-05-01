package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
