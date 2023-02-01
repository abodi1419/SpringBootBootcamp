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
@Table(name = "instructors")
@Repository
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name can not be null!")
    @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters")
    @Column(columnDefinition = "varchar(60) not null")
    private String name;

    @NotNull(message = "email can not be null!")
    @Email(message = "email syntax is not valid!")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;

    @NotNull(message = "major can not be null!")
    @Column(columnDefinition = "varchar(30) not null")
    private String major;

    @NotNull(message = "age can not be null!")
    @Column(columnDefinition = "int not null")
    private int age;

    @NotNull(message = "salary can not be null!")
    @Column(columnDefinition = "float(10,2) not null")
    private float salary;
}


