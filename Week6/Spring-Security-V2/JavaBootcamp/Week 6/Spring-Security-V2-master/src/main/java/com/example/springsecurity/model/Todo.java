package com.example.springsecurity.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private  String message;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "myUser", referencedColumnName = "id")
    @JsonIgnore
    private MyUser myUser;
}
