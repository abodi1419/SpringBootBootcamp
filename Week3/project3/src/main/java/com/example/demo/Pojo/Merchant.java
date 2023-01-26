package com.example.demo.Pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
    @NotNull(message = "Id must not be null!")
    @Size(min = 3, message = "Id must be 3 characters long at least!")
    private String id;
    @NotNull(message = "Name must not be null!")
    @Size(min = 3, message = "Name must be 3 characters long at least!")
    private String name;
}
