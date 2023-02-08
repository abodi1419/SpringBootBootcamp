package com.example.homework22.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@Repository
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(80)", nullable = false)
    @NotNull(message = "Name cannot be null!")
    @Size(min = 2, max = 50,message = "Name must be between 2 and 80 characters!")
    private String name;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    @NotNull(message = "Major cannot be null!")
    @Size(min = 2, max = 50,message = "Major must be between 2 and 50 characters!")
    private String major;
    @Column(columnDefinition = "int", nullable = false)
    @NotNull(message = "Age cannot be null!")
    @Positive(message = "Age must positive integer!")
    private Integer age;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

}


