package com.example.homework22.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseDTO {
    @NotNull(message = "name must be not null!")
    @Size(min = 3, max = 50,message = "Area must be between 3 and 50 characters!")
    private String name;

    private int teacher_id;
}
