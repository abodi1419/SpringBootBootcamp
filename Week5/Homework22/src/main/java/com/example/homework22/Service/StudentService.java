package com.example.homework22.Service;

import com.example.homework22.Exception.ApiException;
import com.example.homework22.Model.Course;
import com.example.homework22.Model.Student;
import com.example.homework22.Repository.CourseRepository;
import com.example.homework22.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
   private final CourseService courseService;
   private final CourseRepository courseRepository;



    public Student findById(Integer id){
        Student student = studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiException("Student not found!", 404);
        }
        return student;
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void attach(Integer student_id, Integer course_id){
        Student student = findById(student_id);
        Course course = courseService.findById(course_id);
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        studentRepository.save(student);
    }

    public void detach(Integer student_id, Integer course_id){
        Student student = findById(student_id);
        Course course = courseService.findById(course_id);
        student.getCourses().remove(course);
        course.getStudents().remove(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }
//    public String getTeacherName(Integer student_id){
//        Student student = findById(student_id);
//        Teacher teacher = student.getTeacher();
//        if(teacher==null){
//            return "null";
//        }
//        return teacher.getName();
//
//    }

    public void deleteStudent(Integer student_id){
        Student student = findById(student_id);
        studentRepository.delete(student);

    }



//    public Director findById(Integer id){
//        Director director =directorRepository.findDirectorById(id);
//        if(director==null){
//            throw new ApiException("Director not found",404);
//        }
//        return director;
//    }
//
//
//
    public void updateStudent(Integer id, Student student){
        Student oldStudent = studentRepository.findStudentById(id);
        if(oldStudent ==null){
            throw new ApiException("Student not found!",404);
        }

        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
//        oldStudent.setMajor(student.getMajor());
        studentRepository.save(oldStudent);
    }

    public void updateStudentMajor(Integer id, String major){
        Student oldStudent = studentRepository.findStudentById(id);
        if(oldStudent ==null){
            throw new ApiException("Student not found!",404);
        }


        oldStudent.setMajor(major);
        oldStudent.setCourses(null);
        studentRepository.save(oldStudent);
    }

//    public void deleteAddress(Integer id){
//        Address address = addressRepository.findAddressById(id);
//        if(address ==null){
//            throw new ApiException("Address not found!",404);
//        }
//        addressRepository.delete(address);
//    }
//
//
//
//    public List<Director> getDirectorsByName(String name){
//        List<Director> directors = directorRepository.findDirectorsByNameIsLike(name);
//        if(directors.isEmpty()){
//            throw new ApiException("No directors found with name provided! ",404);
//        }
//        return directors;
//    }


}
