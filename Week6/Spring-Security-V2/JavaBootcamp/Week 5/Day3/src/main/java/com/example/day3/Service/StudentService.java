package com.example.day3.Service;

import com.example.day3.Exception.ApiException;
import com.example.day3.Model.Course;
import com.example.day3.Model.Student;
import com.example.day3.Repository.CourseRepository;
import com.example.day3.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    private final CourseService courseService;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student oldStudent = studentRepository.findById(id).orElse(null);

        if(oldStudent == null)
            throw new ApiException("ID not found");

        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findById(id).orElse(null);

        if (student == null){
            throw new ApiException("ID not found");
        }

        studentRepository.delete(student);
    }

    public void updateStudentMajor(Integer id, String major){
        Student student = studentRepository.findStudentById(id);

        if(student == null){
            throw new ApiException("ID not found");
        }
        student.setMajor(major);
        for (Course course: student.getCourses()) {
            courseService.getCourseStudents(course.getId()).remove(student);
            courseRepository.save(course);
        }
        student.getCourses().clear();
        studentRepository.save(student);
    }

    public void assignStudentToCourse(Integer student_id, Integer course_id){
        Student student = studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseById(course_id);

        if (student == null || course == null)
            throw new ApiException("Wrong Data");

        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }


}
