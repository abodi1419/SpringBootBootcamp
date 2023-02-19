package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotNull(message = "Book count is required")
    @PositiveOrZero(message = "Book count must be positive")
    @Column(columnDefinition = "int not null check(book_count>=0)")
    private int book_count;

    @NotNull(message = "Genre is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "store_id" ,referencedColumnName = "id")
    @JsonIgnore
    private Store store;
}
