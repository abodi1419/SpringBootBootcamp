package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locations")
@Repository
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String area;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String street;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Store store;

    public Location(String area, String street, Store store) {
        this.area = area;
        this.street = street;
        this.store = store;
    }
}


