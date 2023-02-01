package com.example.directormicroservice.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "directors")
@Repository
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Name can not be null!")
    @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters")
    @Column(columnDefinition = "varchar(60) not null")
    private String name;






}


