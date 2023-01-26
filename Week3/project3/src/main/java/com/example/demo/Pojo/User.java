package com.example.demo.Pojo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "Id must not be null!")
    @Size(min = 3, message = "Id must be 3 characters long at least!")
    private String id;
@NotEmpty(message = "Username must contain a value!")
@NotBlank(message = "Username should not contain a space")
@Size(min = 5, max = 30, message = "Username must be between 5 and 30 characters!")
    private String username;

@Size(min = 6, max = 50, message = "Password must be 6 characters at least!")
    private String password;
@NotNull(message = "Email must not be null")
@Email(message = "Email must be in email form")
private String email;
@NotNull(message = "Role must not be null!")
@Pattern(regexp = "(?:^|\\W)Admin(?:$|\\W)|(?:^|\\W)Customer(?:$|\\W)", message = "Role must be Admin or Customer!")
private String role;
@NotNull(message = "Balance must not be null!")
@PositiveOrZero(message = "Balance must be positive number")
private double balance;

    @Override
    public String toString() {
        return "User {"
                +"\"username\": \""+username+"\","
                +"\"password\": \""+password+"\","
                +"}";
    }
}
