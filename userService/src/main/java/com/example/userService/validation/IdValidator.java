package com.example.userService.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<ValidId, String> {

    @Override
    public boolean isValid(String id, ConstraintValidatorContext context) {
        if (id == null || !id.matches("\\d+")) {
            context.disableDefaultConstraintViolation(); // מבטל את ההודעה הכללית
            context.buildConstraintViolationWithTemplate("id need to contain digit only")
                   .addConstraintViolation();
            return false;
        }

        if (id == null || !id.matches("\\d{5,9}")) {
            context.disableDefaultConstraintViolation(); // מבטל את ההודעה הכללית
            context.buildConstraintViolationWithTemplate("id need to contain between 5 to 9 digit")
                   .addConstraintViolation();
            return false;
        }

        id = String.format("%09d", Integer.parseInt(id)); // משלימים ל־9 ספרות

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(id.charAt(i));
            int calc = digit * ((i % 2) + 1);
            if (calc > 9) calc -= 9;
            sum += calc;
        }

        return sum % 10 == 0;

    }
}