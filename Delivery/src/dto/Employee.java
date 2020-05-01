package dto;

import java.time.LocalDate;
import java.util.HashSet;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import dto.validation.IllegalDriver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@IllegalDriver(minAge = 18)
@JsonInclude(Include.NON_NULL)
public class Employee extends Person {

	@DecimalMin("4.00") @DecimalMax("150.00")
	private Double	weight;
	@DecimalMin("50.00") @DecimalMax("250.00")
	private Double	height;
	private Boolean	maried;
	private HashSet<LicenseCategory>	driverLicenseCategory;
	@PastOrPresent
	@NotNull(message = "For employee you must input date begin a contract")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate	dateBeginContract;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate	dateEndContract;

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Builder(builderMethodName = "employeeBuilder")
	public Employee(Long id,
			String firstName,
			String lastName,
			LocalDate dateBirthday, HashSet<PhoneNumber> phone, String email, Address address,
			Double weight, Double height, Boolean maried,
			HashSet<LicenseCategory> driverLicenseCategory,  
			LocalDate dateBeginContract,
			LocalDate dateEndContract) {
		super(id, firstName, lastName, dateBirthday, phone, email, address);
		this.weight = weight;
		this.height = height;
		this.maried = maried;
		this.driverLicenseCategory = driverLicenseCategory;
		this.dateBeginContract = dateBeginContract;
		this.dateEndContract = dateEndContract;
	}
	

	
}
