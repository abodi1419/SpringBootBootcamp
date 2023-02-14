package com.example.homework28.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity @Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Quantity can not be null")
    @Min(value = 0, message = "Quantity can not be negative!")
    private  Integer quantity;

    @NotNull(message = "Total price can not be null")
    @Positive( message = "totalPrice must be positive!")
    private Double totalPrice;

    //
    @Column(columnDefinition = "TIMESTAMP not null")
    private Date dateReceived;

    // check(status='new' or status='inProgress' or status='completed') default 'new
    @Column(columnDefinition = "varchar(12)  default 'new' check(status='new' or status='inProgress' or status='completed')")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private MyUser myUser;
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;


}
