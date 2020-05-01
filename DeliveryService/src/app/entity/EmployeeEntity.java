package app.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Entity
@Table(name = "employee")
public class EmployeeEntity extends PersonEntity {

	
	double weigth;
	double heigth;
	boolean maried;
	LocalDate	dateBeginContract;
	LocalDate	dateEndContract;
	@ManyToMany
	Set<LicenseCategoryEntity> licenseCategory;
	
}
