package dto.validation;

import static java.lang.annotation.ElementType.*;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Size(min = 7, max = 12)
@Pattern(regexp = "\\d*")
@Constraint(validatedBy = { })
@Documented
public @interface PhoneValid {
    String message() default "Wrong phone input";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
