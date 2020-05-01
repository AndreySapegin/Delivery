package dto.validation;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import dto.Employee;
import dto.LicenseCategory;

public class IllegalDriverValidator implements ConstraintValidator<IllegalDriver, Employee>{

	private int minAge;
	
	@Override
	public boolean isValid(Employee person, ConstraintValidatorContext context) {
		
		Boolean result = true;
		int ageFullYeas = (Period.between(person.getDateBirthday(), LocalDate.now())).getYears();
		var licesies = person.getDriverLicenseCategory();
		if (licesies == null) return true;
		for (LicenseCategory lc : licesies) {result&=lc.getMinAge()<=ageFullYeas;}
		result&=minAge<=ageFullYeas;
		return result;
	}

	@Override
	public void initialize(IllegalDriver illegalDriver) {
		this.minAge = illegalDriver.minAge();
	}
}
