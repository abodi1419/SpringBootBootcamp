package com.example.homework22.Repository;


import com.example.homework22.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);
}