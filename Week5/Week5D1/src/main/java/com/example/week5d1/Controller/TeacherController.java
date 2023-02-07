package com.example.week5d1.Controller;


import com.example.week5d1.DTO.AddressDTO;
import com.example.week5d1.Model.Teacher;
import com.example.week5d1.Service.AddressService;
import com.example.week5d1.Service.TeacherService;
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

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getTeacher(@PathVariable Integer id){
        Teacher teacher = teacherService.findById(id);
        return ResponseEntity.status(200).body(teacher);
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



    @PutMapping("update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("Updated successfully");

    }

    @PutMapping("update/address")
    public ResponseEntity updateTeacherDetail(@RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
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

}
