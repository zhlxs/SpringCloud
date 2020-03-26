package com.demo.sp.annotation;
import com.demo.sp.util.FlagValidatorClass;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator
{
    String[] value() default {};

    String message() default "flag is not found!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
