package com.example.homework22.Repository;



import com.example.homework22.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);
}