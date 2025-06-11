package com.example.userService.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidId {
    String message() default "Invalid ID format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
