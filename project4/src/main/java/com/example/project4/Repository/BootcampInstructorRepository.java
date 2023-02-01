package com.example.project4.Repository;

import com.example.project4.Model.BootcampInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BootcampInstructorRepository extends JpaRepository<BootcampInstructor,Integer> {

    BootcampInstructor findBootcampInstructorByBootcampIdAndInstructorId(Integer bootcampId, Integer instructorId);
    List<BootcampInstructor> findBootcampInstructorsByBootcampId(Integer bootcampId);
    List<BootcampInstructor> findBootcampInstructorsByInstructorId(Integer instructor);


}
