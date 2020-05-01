package dto.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = IllegalDateSequenceImpl.class)
@Retention(RUNTIME)
@Target(TYPE)
public @interface IllegalDateSequence {
	String message() default "Dates and time in wrong sequence";
	
	Class<?>[] groups() default {};
	Class<? super Payload>[] payload() default {}; 
}
