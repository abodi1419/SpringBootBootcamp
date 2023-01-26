package com.example.demo.Pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    /*

    id ( must not be empty , have to be 3 character long ).
    name ( must not be empty , have to be 3 length long ).
    price ( must not be empty , must be positive number ).
    categoryID ( must not be empty , have to be 3 character long ).

     */
    @NotNull(message = "Id must not be null!")
    @Size(min = 3, message = "Id must be 3 characters long at least!")
    private String id;
    @NotNull(message = "Name must not be null!")
    @Size(min = 3, message = "Name must be 3 characters long at least!")
    private String name;
    @NotNull(message = "Price must not be null!")

    @Positive
    private double price;
    @NotNull(message = "Category id must not be null!")
    @Size(min = 3, message = "Category id must be 3 characters long at least!")
    private String categoryId;
}
