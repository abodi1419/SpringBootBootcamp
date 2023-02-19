package com.example.day3.Service;

import com.example.day3.Exception.ApiException;
import com.example.day3.Model.Course;
import com.example.day3.Model.Student;
import com.example.day3.Model.Teacher;
import com.example.day3.Repository.CourseRepository;
import com.example.day3.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
        Course oldCourse = courseRepository.findById(id).orElse(null);

        if(oldCourse == null)
            throw new ApiException("ID not found");

        course.setName(course.getName());
        courseRepository.save(course);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findById(id).orElse(null);

        if (course == null){
            throw new ApiException("ID not found");
        }
        courseRepository.delete(course);
    }

    public String getCourseTeacherName(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course == null)
            throw new ApiException("ID not found");
        if (course.getTeacher() == null)
            throw new ApiException("the course has no teacher");
        return course.getTeacher().getName();
    }


    public void assignCourseToTeacher(Integer teacher_id, Integer course_id) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);
        if (teacher ==null || course == null)
            throw new ApiException("ID not found");

        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public List<Student> getCourseStudents(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course == null)
            throw new ApiException("ID not found");
        return course.getStudents();
    }

}
