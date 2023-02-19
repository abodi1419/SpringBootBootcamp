package com.example.day3.Controller;

import com.example.day3.Model.Student;
import com.example.day3.Service.AddressService;
import com.example.day3.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/all")
    public ResponseEntity getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("Student Updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student was deleted");
    }

    @PutMapping("/{student_id}/course/{course_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer student_id, @PathVariable Integer course_id){
        studentService.assignStudentToCourse(student_id,course_id);
        return ResponseEntity.status(200).body("Student assigned to the course");
    }

    @PutMapping("/update/{id}/{major}")
    public ResponseEntity updateStudentMajor(@PathVariable Integer id, @PathVariable String major){
        studentService.updateStudentMajor(id, major);
        return ResponseEntity.status(200).body("Student major Updated");
    }
}
