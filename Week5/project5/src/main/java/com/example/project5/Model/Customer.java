package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "customers")
@Repository
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(80)", nullable = false)
    @NotNull(message = "Name cannot be null!")
    @Size(min = 2, max = 50,message = "Name must be between 2 and 80 characters!")
    private String name;
    @Column(columnDefinition = "varchar(12)", nullable = false)
    @NotNull(message = "Phone cannot be null!")
    @Size(min = 9, max = 12,message = "Phone must be between 9 and 12 characters!")
    private String phone;
    @Column(columnDefinition = "varchar(100)", nullable = false, unique = true)
    @NotNull(message = "Email cannot be null!")
    @Email(message = "Email must be in email form!")
    private String email;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JsonIgnore
    private List<Store> stores;

}


