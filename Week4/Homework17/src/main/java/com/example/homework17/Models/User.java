package com.example.homework17.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Name can not be null!")
    @Size(min = 5, max = 30, message = "Username must be between 5 and 30 characters")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @NotNull(message = "Username can not be null!")
    @Size(min = 5, max = 30, message = "Username must be between 5 and 30 characters")
    @Column(columnDefinition = "varchar(30) not null", unique = true)
    private String username;
    @NotNull(message = "Password can not be null!")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;
    @NotNull(message = "Email can not be null!")
    @Column(columnDefinition = "varchar(50) not null", unique = true)
    @Email(message = "Email must be in email form")
    private String email;
    @NotNull(message = "Role can not be null!")
    @Column(columnDefinition = "varchar(5) check(role='user' or role='admin') not null")
    private String role;
    @NotNull(message = "Age can not be null!")
    @Column(columnDefinition = "int not null")
    private Integer age;

}
