package com.example.homework14.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    @NotNull(message = "Id must has a value!")
    @Min(value = 3, message = "ID must be greater than 2!")
    private String id;
    @NotNull(message = "Name must hava a value!")
    @Size(min = 5, message = "Name must have more than 4 characters!")
    private String name;
    @NotNull(message = "Age must has a value!")
    @Min(value = 26, message = "Age must be greater than 25!")
    @Positive
    private int age;
    @NotNull(message = "Role must have a value!")
    @Pattern(regexp = "(?:^|\\W)supervisor(?:$|\\W)|(?:^|\\W)coordinator(?:$|\\W)", message = "Role must be coordinator or supervisor!")
    private String role;

    private boolean onLeave = false;
    @NotNull(message = "Employment year must have a value!")
    @Min(value = 1990, message = "Employment year must  be greater than 1990!")
    @Max(value = 2022, message = "Employment year must  be less than 2022!")

    private int employmentYear;
    @NotNull(message = "Annual leave must have a value!")
    private int annualLeave;

    public Employee(String id, String name, int age, String role, int employmentYear, int annualLeave) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
        this.onLeave=false;
        this.employmentYear = employmentYear;
        this.annualLeave = annualLeave;
    }
}
