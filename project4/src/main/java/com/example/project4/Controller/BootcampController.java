package com.example.project4.Controller;

import com.example.project4.Model.Bootcamp;
import com.example.project4.Model.BootcampInfo;
import com.example.project4.Model.Instructor;
import com.example.project4.Model.Student;
import com.example.project4.Service.BootcampService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/bootcamp")
public class BootcampController {
    private final BootcampService bootcampService;

    @GetMapping("/get")
    public ResponseEntity getBootcamps(){
        return ResponseEntity.status(200).body(bootcampService.getAll());
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getBootcampById(@PathVariable Integer id){
        Bootcamp bootcamp = bootcampService.findById(id);
        return ResponseEntity.status(200).body(bootcamp);
    }

    @GetMapping("/get/instructors/{id}")
    public ResponseEntity getBootcampInstructors(@PathVariable Integer id){
        List<Instructor> instructors = bootcampService.getInstructors(id,false);
        return ResponseEntity.status(200).body(instructors);
    }

    @GetMapping("/get/students/{id}")
    public ResponseEntity getBootcampStudents(@PathVariable Integer id){
        List<Student> students = bootcampService.getStudents(id,false);
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/get/info/{id}")
    public ResponseEntity getBootcampInfo(@PathVariable Integer id){
        BootcampInfo bootcampInfo = bootcampService.getInfo(id);
        return ResponseEntity.status(200).body(bootcampInfo);
    }

    @GetMapping("/get/name")
    public ResponseEntity getBootcampByName(@RequestBody Bootcamp bootcamp){
        List<Bootcamp> bootcamps = bootcampService.getByName(bootcamp.getName());
        return ResponseEntity.status(200).body(bootcamps);
    }

    @PostMapping("/add")
    public ResponseEntity addBootcamp(@RequestBody @Valid Bootcamp bootcamp){
        bootcampService.addBootcamp(bootcamp);
        return ResponseEntity.status(200).body("Bootcamp added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateBootcamp(@PathVariable Integer id, @RequestBody @Valid Bootcamp bootcamp){
        bootcampService.updateBootcamp(id, bootcamp);
        return ResponseEntity.status(200).body("Updated successfully");

    }

    @PutMapping("get/running")
    public ResponseEntity getRunningBootcamps(){
        return ResponseEntity.status(200).body(bootcampService.getRunning());

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteBootcamp(@PathVariable Integer id){
        bootcampService.deleteBootcamp(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }


}
