package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
@Repository
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String name;
    
    @Column(columnDefinition = "int default 0")
    private Integer bookCount;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String genre;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonIgnore
    private Store store;


    public Book(String name, Integer bookCount, String genre, Store store) {
        this.name = name;
        this.bookCount = bookCount;
        this.genre = genre;
        this.store = store;
    }
}


