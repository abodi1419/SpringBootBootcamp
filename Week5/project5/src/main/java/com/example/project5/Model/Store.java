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
@Table(name = "stores")
@Repository
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Name can not be null!")
    @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters")
    @Column(columnDefinition = "varchar(60) not null")
    private String name;


    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Location location;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "store_id")
    private List<Book> books;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "stores_customers",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    List<Customer> customers;


}


