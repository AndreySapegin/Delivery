package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.PhoneNumberEntity;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumberEntity, String> {

}
