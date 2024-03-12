package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String firstName;

    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName = "";

    @NotNull(message = "is required")
    @Min(value=0, message="must be greater than or equal to zero")
    @Max(value=10, message="must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 chars/digits")
    private String postalCode;

    @CourseCode(value = "DACM" , message = "Must starts with DACM")
    private String courseCode;

}
