package com.example.project5.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookDTO {
    @NotNull(message = "name must be not null!")
    @Size(min = 3, max = 50,message = "Name must be between 3 and 50 characters!")
    private String name;

    @PositiveOrZero
    private Integer bookCount;


    @NotNull(message = "Genre must be not null!")
    @Size(min = 3, max = 50,message = "Genre must be between 3 and 50 characters!")
    private String genre;


    private int store_id;
}
