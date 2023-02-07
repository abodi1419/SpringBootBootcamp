package com.example.homework22.Service;


import com.example.homework22.DTO.AddressDTO;
import com.example.homework22.DTO.CourseDTO;
import com.example.homework22.Exception.ApiException;
import com.example.homework22.Model.Address;
import com.example.homework22.Model.Course;
import com.example.homework22.Model.Teacher;
import com.example.homework22.Repository.AddressRepository;
import com.example.homework22.Repository.CourseRepository;
import com.example.homework22.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;


    public Course findById(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("Course not found!", 404);
        }
        return course;
    }
    public void addCourse(CourseDTO courseDTO){
        Teacher teacher = teacherRepository.findTeacherById(courseDTO.getTeacher_id());
        Course course = new Course(courseDTO.getName(), teacher);
        courseRepository.save(course);
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public void attach(Integer course_id, Integer teacher_id){
        Course course = findById(course_id);
        Teacher teacher = teacherService.findById(teacher_id);
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void detach(Integer course_id){
        Course course = findById(course_id);
        course.setTeacher(null);
        courseRepository.save(course);
    }
    public String getTeacherName(Integer course_id){
        Course course = findById(course_id);
        Teacher teacher = course.getTeacher();
        if(teacher==null){
            return "null";
        }
        return teacher.getName();

    }

    public void deleteCourse(Integer course_id){
        Course course = findById(course_id);
        courseRepository.delete(course);

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
    public void updateCourse(Integer id, CourseDTO courseDTO){
        Course course = courseRepository.findCourseById(id);
        if(course ==null){
            throw new ApiException("Course not found!",404);
        }
        if(courseDTO.getTeacher_id()>0){
            Teacher teacher = teacherService.findById(courseDTO.getTeacher_id());
            course.setTeacher(teacher);
        }
        course.setName(courseDTO.getName());
        courseRepository.save(course);
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
