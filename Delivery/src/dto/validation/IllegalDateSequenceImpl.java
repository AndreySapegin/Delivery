package dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import dto.RangeTime;

public class IllegalDateSequenceImpl implements ConstraintValidator<IllegalDateSequence, RangeTime> {

	@Override
	public boolean isValid(RangeTime value, ConstraintValidatorContext context) {
		return value.getFrom().isBefore(value.getTo());
	}

}
