package com.example.project5.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LocationDTO {
    @NotNull(message = "Area must be not null!")
    @Size(min = 3, max = 50,message = "Area must be between 3 and 50 characters!")
    private String area;
    @NotNull(message = "Street can not be null!")
    @Size(min = 3, max = 50, message = "Street must be between 3 and 50 characters!")
    private String street;

    @NotNull(message = "Store id must not be null!")
    @Positive(message = "Store id must be positive integer!")
    private int store_id;
}
