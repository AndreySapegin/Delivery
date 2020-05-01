package dto.validation;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = IllegalDriverValidator.class)
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface IllegalDriver {

	int minAge();
	String message() default "Age dont is enouth for driver license";
	
	Class<?>[] groups() default {};
	Class<? super Payload>[] payload() default {}; 
}
