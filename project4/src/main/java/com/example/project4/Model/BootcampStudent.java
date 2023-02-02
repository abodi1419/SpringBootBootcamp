package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bootcamp_students_relation")
public class BootcampStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Bootcamp id is required!")
    @Column(columnDefinition = "int not null")
    private Integer bootcampId;

    @NotNull(message = "student id is required")
    @Column(columnDefinition = "int not null")
    private Integer studentId;

    public BootcampStudent(Integer bootcampId, Integer studentId){
        this.studentId = studentId;
        this.bootcampId = bootcampId;
    }

}
