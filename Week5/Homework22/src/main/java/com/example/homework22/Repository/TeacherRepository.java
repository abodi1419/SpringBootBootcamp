package com.example.homework22.Repository;


import com.example.homework22.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {


    Teacher findTeacherById(Integer id);
    List<Teacher> findTeachersByName(String name);



}