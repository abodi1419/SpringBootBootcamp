package com.example.day4.Pojo;

import jakarta.validation.constraints.*;
import jakarta.validation.valueextraction.ExtractedValue;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    @NotEmpty(message = "you must enter an id")
    @Size(min = 2, message = "id must be at least 2 digits")
    private String id;

    @NotEmpty(message = "you must enter a name")
    @Size(min = 4, message = "name must be more than 4 letters")
    private String name;
    @NotNull(message = "you must enter an age")
    @Min(value = 25, message = "age must be more than 25")
    private int age;
    @NotEmpty(message = "you must enter a role")
    @Pattern(regexp = "\\b(supervisor|coordinator)\\b", message = "role must be supervisor or coordinator")
    private String role;
    @AssertFalse(message = "employee cannot be on leave")
    private boolean onLeave;
    @NotNull(message = "you must enter an employment year")
    @Min(value = 2005, message = "employment year must be 2005 or more")
    @Max(value = 2023, message = "employment year must be 2023 or less")
    private int employmentYear;
    @NotNull(message = "you must enter an annual leave")
    @PositiveOrZero(message = "annual year must be positive or zero")
    private int annualLeave;
}
