package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.RangeTimeEntity;

public interface RangeTimeRepository extends JpaRepository<RangeTimeEntity, Long> {

}
