package com.example.project4.Controller;

import com.example.project4.Model.Student;
import com.example.project4.Service.BootcampStudentService;
import com.example.project4.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    private final BootcampStudentService bootcampStudentService;
    
    public StudentController(BootcampStudentService bootcampStudentService,
                             StudentService studentService){
        this.studentService         = studentService;
        this.bootcampStudentService = bootcampStudentService;
    }

    @GetMapping("/get")
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
        studentService.updateStudent(id,student);
        return ResponseEntity.status(200).body("Student Updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student was deleted");
    }

    @PutMapping("/assign/{bootcampId}/{studentId}")
    public ResponseEntity assignInstructor(@PathVariable Integer bootcampId, @PathVariable Integer studentId){
        bootcampStudentService.addBootcampStudent(bootcampId, studentId);
        return ResponseEntity.status(200).body("Student was assigned successfully");
    }

    @DeleteMapping("/resign/{bootcampId}/{studentId}")
    public ResponseEntity resignInstructors(@PathVariable Integer bootcampId, @PathVariable Integer studentId){
        bootcampStudentService.deleteStudentFromBootcamp(bootcampId,studentId);
        return ResponseEntity.status(200).body("Student resigned from bootcamp successfully");
    }

    @GetMapping("/get/bootcamp/{studentId}")
    public ResponseEntity getStudents(@PathVariable Integer studentId){
        return ResponseEntity.status(200).body(studentService.getBootcamp(studentId));
    }

    @GetMapping("/get/age/{age}")
    public ResponseEntity getStudentsWith(@PathVariable Integer age){
        return ResponseEntity.status(200).body(studentService.getAllStudentAbove(age));
    }

    @GetMapping("/get/major/{major}")
    public ResponseEntity getStudentsWith(@PathVariable String major){
        return ResponseEntity.status(200).body(studentService.getAllStudentWith(major));
    }

}
