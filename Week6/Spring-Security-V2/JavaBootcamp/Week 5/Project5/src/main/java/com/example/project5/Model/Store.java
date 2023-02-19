package com.example.project5.Model;

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
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "store")
    @PrimaryKeyJoinColumn
    private Location location;

    @OneToMany(mappedBy = "store")
    private List<Book> books;

    @ManyToMany(mappedBy = "stores")
    private List<Customer> customers;
}
