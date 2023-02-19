package com.example.day3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "float")
    private float totalPrice;

    @Column(columnDefinition = "date")
    private Date dateReceived;

    @Column(columnDefinition = "int")
    private int quantity;
    @Pattern(regexp = "new|inProgress|completed")
    @Column(columnDefinition = "varchar(10) check ( status='new' or status='inProgress' or status='completed')")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
