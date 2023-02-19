package com.example.project5.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @NotNull(message = "Phone number is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String phone_number;

    @NotNull(message = "Email is required")
    @Email(message = "Not valid email syntax")
    @Column(columnDefinition = "varchar(30) not null")
    private String email;


    @ManyToMany
    @JsonIgnore
    private List<Store> stores;

}
