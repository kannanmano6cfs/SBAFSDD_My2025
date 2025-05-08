package com.learning.exproductservice.utility;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductNameValidator.class)
public @interface ValidName {
    String message() default "Product name must starts with an upper case letter";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
