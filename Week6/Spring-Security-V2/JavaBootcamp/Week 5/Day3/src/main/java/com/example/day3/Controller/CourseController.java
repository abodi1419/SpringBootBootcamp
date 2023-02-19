package com.example.day3.Controller;

import com.example.day3.Model.Course;
import com.example.day3.Service.AddressService;
import com.example.day3.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;


    @GetMapping("/all")
    public ResponseEntity getCourses(){
        return ResponseEntity.status(200).body(courseService.getCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @Valid @RequestBody Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("Course Updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course was deleted");
    }

    @PutMapping("/{course_id}/teacher/{teacher_id}")
    public ResponseEntity assign(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        courseService.assignCourseToTeacher(teacher_id,course_id);
        return ResponseEntity.status(200).body("teacher was assigned");
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id){
        return ResponseEntity.status(200).body("The teacher name is "+courseService.getCourseTeacherName(id));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getCourseStudents(@PathVariable Integer id){
        return ResponseEntity.status(200).body(courseService.getCourseStudents(id));
    }
}
