package com.example.day1.Controller;

import com.example.day1.DTO.AddressDTO;
import com.example.day1.Model.Teacher;
import com.example.day1.Service.AddressService;
import com.example.day1.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final AddressService addressService;


    @GetMapping("/all")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("Teacher Updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher was deleted");
    }

    @PostMapping("/details/add")
    public ResponseEntity addTeacherDetails(@Valid @RequestBody AddressDTO cd){
        addressService.addTeacherDetails(cd);
        return ResponseEntity.status(200).body("Teacher address Added");
    }

    @PutMapping("/details/update")
    public ResponseEntity updateTeacherDetails(@Valid @RequestBody AddressDTO cd){
        addressService.updateTeacherDetails(cd);
        return ResponseEntity.status(200).body("Teacher address Updated");
    }

    @DeleteMapping("/details/delete/{id}")
    public ResponseEntity deleteTeacherDetails(@PathVariable Integer id){
        addressService.deleteTeacherDetails(id);
        return ResponseEntity.status(200).body("Teacher address was deleted");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getTeacher(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacher(id));
    }
}
