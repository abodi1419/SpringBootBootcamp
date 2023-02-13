package com.example.homework27.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity @Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Title can not be null")
    @Size(min=3, max = 100, message = "Title must be between 3 and 100 characters")
    private  String title;

    @NotNull(message = "Body can not be null")
    @Size(min=3, max = 100, message = "Body must be between 10 and 255 characters")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private MyUser myUser;
}
