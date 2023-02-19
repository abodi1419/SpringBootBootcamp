package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bootcamp_instructors_relation")
@Repository
public class BootcampInstructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Bootcamp id can not null")
    @Column(columnDefinition = "int not null")
    private Integer bootcampId;

    @NotNull(message = "instructor id can not null")
    @Column(columnDefinition = "int not null")
    private Integer instructorId;


    public BootcampInstructor(Integer bootcampId, Integer instructorId){
        this.instructorId = instructorId;
        this.bootcampId = bootcampId;
    }

}


