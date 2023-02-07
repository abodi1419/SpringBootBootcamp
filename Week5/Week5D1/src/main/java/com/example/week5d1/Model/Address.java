package com.example.week5d1.Model;

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
@Table(name = "addresses")
@Repository
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String area;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String street;
    @Column(columnDefinition = "int", nullable = false)
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

    public Address(String area, String street, Integer buildingNumber, Teacher teacher) {
        this.area = area;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.teacher = teacher;
    }
}


