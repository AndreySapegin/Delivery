package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.LicenseCategoryEntity;

public interface LicenseCategoryRepository extends JpaRepository<LicenseCategoryEntity, String> {

}
