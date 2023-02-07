package com.example.homework22.Model;

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
@Table(name = "courses")
@Repository
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacher;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }
}


