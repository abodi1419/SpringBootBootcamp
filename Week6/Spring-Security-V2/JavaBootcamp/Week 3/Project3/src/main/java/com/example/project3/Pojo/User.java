package com.example.project3.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

//    id ( must not be empty , have to be 3 character long ).
//    username ( must not be empty , have to be 5 length long ).
//    password ( must not be empty , have to be 6 length long , must have characters and digits ).
//    email ( must not be empty , must be valid email ).
//    role ( must not be empty , have to be in ( “Admin”,”Customer”) ).
//    balance ( must not be empty , have to be positive ).
    @NotEmpty(message = "id is required")
    @Size(min = 3, message = "id has to be at least 3 Characters")
    private String id;

    @NotEmpty(message = "username is required")
    @Size(min = 5, message = "username has to be at least 5 Characters")
    private String username;

    @NotEmpty(message = "password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$", message = "password has to be at least 6 Characters, containing at least one digit and one character")
    private String password;

    @NotEmpty(message = "email is required")
    @Email(message = "email is not a valid structure.")
    private String email;

    @NotEmpty(message = "id is required")
    @Size(min = 3, message = "id has to be at least 3 Characters")
    @Pattern(regexp = "\\b(Admin|Customer)\\b", message = "Role must be Admin or Customer (CASE SENCITIVE)")
    private String role;

    @NotNull(message = "balance is required")
    @PositiveOrZero(message = "balance has to be a positive number")
    private double balance;
}
