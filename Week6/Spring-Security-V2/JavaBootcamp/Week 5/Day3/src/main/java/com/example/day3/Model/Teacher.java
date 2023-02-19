package com.example.day3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "name is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotNull(message = "age is required")
    @Column(columnDefinition = "int not null")
    private int age;

    @NotNull(message = "email is required")
    @Email(message = "must be email syntax")
    @Column(columnDefinition = "varchar(70) not null")
    private String email;

    @NotNull(message = "salary is required")
    @PositiveOrZero(message = "salary must be 0 or more")
    @Column(columnDefinition = "float not null check (salary>=0)")
    private float salary;

    @OneToOne( cascade = CascadeType.REMOVE ,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Course> courses;
}
