package com.example.homework22.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressDTO {
    @NotNull(message = "Area must be not null!")
    @Size(min = 3, max = 50,message = "Area must be between 3 and 50 characters!")
    private String area;
    @NotNull(message = "Street can not be null!")
    @Size(min = 3, max = 50, message = "Street must be between 3 and 50 characters!")
    private String street;
    @NotNull(message = "Building number con not be null!")
    @Positive(message = "Building number must be greater than 0!")
    private Integer buildingNumber;

    @NotNull(message = "Teacher id must not be null!")
    @Positive(message = "Teacher id must be positive integer!")
    private int teacher_id;
}
