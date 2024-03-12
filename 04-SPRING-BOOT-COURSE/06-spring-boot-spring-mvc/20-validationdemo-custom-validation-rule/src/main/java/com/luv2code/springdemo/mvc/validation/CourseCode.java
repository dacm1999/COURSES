package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //Define default course code
    public String value() default "LUV";

    //Define default error message
    public String message() default "Must start with luve";

    //Define default groups
    public Class<?>[] groups() default {};

    //Define default payloads -> Provide custom details about validation failure (severity level, error code, etc)
    public  Class <? extends Payload> [] payload() default {};
}
