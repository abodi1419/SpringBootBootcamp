package com.example.day2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Size(min = 5, message = "name length must be 4 or more")
    @Column(columnDefinition = "varchar(30) not null check ( LENGTH(name)>4 )")
    private String name;


    @NotEmpty(message = "User name is required")
    @Size(min = 4, message = "name length must be 4 or more")
    @Column(columnDefinition = "varchar(30) not null unique check (LENGTH(username)>4) ")
    private String username;

    @NotEmpty(message = "Password is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email is not valid ")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @NotEmpty(message = "role is required")
    @Pattern(regexp = "\\b(user|admin)\\b")
    @Column(columnDefinition = "varchar(5) not null check ( role='admin' or role='user')")
    private String role;


    @NotNull(message = "age is required")
    @Positive(message = "age must be positive")
    @Column(columnDefinition = "int not null check ( age > 0 ) ")
    private Integer age;

}
