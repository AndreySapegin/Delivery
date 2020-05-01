package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.DeliveryEntity;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {

}
