package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name is required!")
    @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters")
    @Column(columnDefinition = "varchar(60) not null")
    private String name;

    @NotNull(message = "Email is required!")
    @Email(message = "email syntax is not valid!")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;

    @NotNull(message = "Major is required!")
    @Column(columnDefinition = "varchar(30) not null")
    private String major;

    @NotNull(message = "Age is required!")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
