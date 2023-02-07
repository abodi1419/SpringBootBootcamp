package com.example.homework22.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "teachers")
@Repository
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Name can not be null!")
    @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters")
    @Column(columnDefinition = "varchar(60) not null")
    private String name;

    @NotNull(message = "Email can not be null!")
    @Email(message = "Email must be email form!")
    @Column(columnDefinition = "varchar(100) not null")
    private String email;

    @NotNull(message = "Age can not be null!")
    @Positive(message = "Age must be greater than 0!")
    private Integer age;

    @NotNull(message = "Salary can not be null!")
    @Positive(message = "Salary must be greater than 0!")
    private Double salary;



    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "teacher_id")
    private List<Course> courses;


}


