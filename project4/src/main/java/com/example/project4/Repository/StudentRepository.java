package com.example.project4.Repository;

import com.example.project4.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("select student from Student student where student.age > ?1")
    List<Student> findStudentByAge(Integer age);

    Student findStudentById(Integer id);

    List<Student> findStudentByMajor(String major);
}
