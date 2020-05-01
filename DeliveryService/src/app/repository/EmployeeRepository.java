package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
