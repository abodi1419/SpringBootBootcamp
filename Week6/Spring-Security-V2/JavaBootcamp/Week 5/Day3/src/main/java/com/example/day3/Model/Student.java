package com.example.day3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "age is required")
    private int age;
    @NotNull(message = "major is required")
    private String major;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Course> courses;
}
