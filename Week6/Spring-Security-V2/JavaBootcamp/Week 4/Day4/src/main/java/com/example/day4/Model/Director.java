package com.example.day4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="director_id_seq", initialValue=100)
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="director_id_seq")
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Size(min = 2, message = "Name length must be more than 1")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String name;
}
