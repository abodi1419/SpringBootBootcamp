package com.example.project4.Controller;

import com.example.project4.Model.BootcampInstructor;
import com.example.project4.Model.Instructor;
import com.example.project4.Service.BootcampInstructorService;
import com.example.project4.Service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructor")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;
    private final BootcampInstructorService bootcampInstructorService;


    @GetMapping("/get")
    public ResponseEntity getInstructors(){
        return ResponseEntity.status(200).body(instructorService.getInstructors());
    }

    @PostMapping("/add")
    public ResponseEntity addInstructor(@Valid @RequestBody Instructor instructor){
        instructorService.addInstructor(instructor);
        return ResponseEntity.status(200).body("Instructor Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateInstructor(@PathVariable Integer id, @Valid @RequestBody Instructor instructor){
        instructorService.updateInstructor(id,instructor);
        return ResponseEntity.status(200).body("Instructor Updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteInstructor(@PathVariable Integer id){
        instructorService.deleteInstructor(id);
        return ResponseEntity.status(200).body("Instructor was deleted");
    }

    @PutMapping("/assign/{bootcampId}/{instructorId}")
    public ResponseEntity assignInstructor(@PathVariable Integer bootcampId, @PathVariable Integer instructorId){
        bootcampInstructorService.addBootcampInstructor(bootcampId, instructorId);
        return ResponseEntity.status(200).body("Instructor was assigned successfully");
    }


    @DeleteMapping("/resign/{bootcampId}/{instructorId}")
    public ResponseEntity resignInstructors(@PathVariable Integer bootcampId, @PathVariable Integer instructorId){
        bootcampInstructorService.deleteInstructorFromBootcamp(bootcampId,instructorId);
        return ResponseEntity.status(200).body("Instructor resign from bootcamp successfully");
    }

    @GetMapping("/get/bootcamps/{instructorId}")
    public ResponseEntity getInstructors(@PathVariable Integer instructorId){
        return ResponseEntity.status(200).body(instructorService.getBootcamps(instructorId));
    }

}
