package com.example.homework22.Controller;



import com.example.homework22.DTO.AddressDTO;
import com.example.homework22.DTO.CourseDTO;
import com.example.homework22.Model.Student;
import com.example.homework22.Model.Teacher;
import com.example.homework22.Service.AddressService;
import com.example.homework22.Service.CourseService;
import com.example.homework22.Service.StudentService;
import com.example.homework22.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final AddressService addressService;
    private final CourseService courseService;
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }

    @GetMapping("/get/courses")
    public ResponseEntity getCourses(){
        return ResponseEntity.status(200).body(courseService.getCourses());
    }

    @GetMapping("/get/students")
    public ResponseEntity getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getTeacher(@PathVariable Integer id){
        Teacher teacher = teacherService.findById(id);
        return ResponseEntity.status(200).body(teacher);
    }

    @GetMapping("/get/course/teacher/{id}")
    public ResponseEntity getTeacherNameOfCourse(@PathVariable Integer id){
        String name = courseService.getTeacherName(id);
        return ResponseEntity.status(200).body(name);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added");
    }

    @PostMapping("/add/address")
    public ResponseEntity addTeacherDetails(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body("Teacher details added");
    }

    @PostMapping("/add/course")
    public ResponseEntity addCourse(@RequestBody @Valid CourseDTO courseDTO){
        courseService.addCourse(courseDTO);
        return ResponseEntity.status(200).body("Course added!");
    }

    @PostMapping("/add/student")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added!");
    }





    @PutMapping("update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("Updated successfully");

    }

    @PutMapping("attach/{teacherId}/course/{courseId}")
    public ResponseEntity attachTeacherToCourse(@PathVariable Integer teacherId, @PathVariable Integer courseId){
        courseService.attach(courseId, teacherId);
        return ResponseEntity.status(200).body("Course attached successfully");

    }

    @PutMapping("attach/student/{studentId}/course/{courseId}")
    public ResponseEntity attachStudentToCourse(@PathVariable Integer studentId, @PathVariable Integer courseId){
        studentService.attach(studentId, courseId);
        return ResponseEntity.status(200).body("Course attached successfully");

    }

    @PutMapping("detach/course/{courseId}")
    public ResponseEntity detachCourseTeacher(@PathVariable Integer courseId){
        courseService.detach(courseId);
        return ResponseEntity.status(200).body("Course teacher detached successfully");

    }

    @PutMapping("detach/student/{studentId}/course/{courseId}")
    public ResponseEntity detachCourseStudent(@PathVariable Integer studentId,@PathVariable Integer courseId){
        studentService.detach(studentId,courseId);
        return ResponseEntity.status(200).body("Course teacher detached successfully");

    }

    @PutMapping("update/address")
    public ResponseEntity updateTeacherDetail(@RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body("Updated successfully");

    }

    @PutMapping("update/course/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@RequestBody @Valid CourseDTO courseDTO){
        courseService.updateCourse(id,courseDTO);
        return ResponseEntity.status(200).body("Updated successfully");

    }

    @PutMapping("update/student/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@RequestBody @Valid Student student){
        studentService.updateStudent(id,student);
        return ResponseEntity.status(200).body("Updated successfully");

    }

    @PutMapping("update/student/{id}/major/{major}")
    public ResponseEntity updateStudentMajor(@PathVariable Integer id,@PathVariable String major){
        studentService.updateStudentMajor(id,major);
        return ResponseEntity.status(200).body("Updated successfully");

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

    @DeleteMapping("delete/address/{id}")
    public ResponseEntity deleteTeacherAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

    @DeleteMapping("delete/course/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

    @DeleteMapping("delete/student/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }



}
