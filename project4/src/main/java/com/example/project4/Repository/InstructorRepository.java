package com.example.project4.Repository;


import com.example.project4.Model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
    Instructor findInstructorById(Integer id);
//    List<Instructor> findInstructorsByIdWithin(List<Integer> ids);

}
