package com.example.project4.Repository;

import com.example.project4.Model.BootcampInstructor;
import com.example.project4.Model.BootcampStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BootcampStudentRepository extends JpaRepository<BootcampStudent, Integer> {

    BootcampStudent findBootcampStudentByBootcampIdAndStudentId(Integer bootcampId, Integer studentId);
    List<BootcampStudent> findBootcampStudentsByBootcampId(Integer bootcampId);

    BootcampStudent findBootcampStudentByStudentId(Integer studentId);

    //Only one bootcamp per student
    //    List<BootcampStudent> findBootcampStudentsByStudentId(Integer studentId);
}
