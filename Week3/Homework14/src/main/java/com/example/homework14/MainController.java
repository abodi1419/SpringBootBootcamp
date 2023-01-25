package com.example.homework14;

import com.example.homework14.Pojo.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MainController {
    ArrayList<Employee> emps = new ArrayList<>();

    @GetMapping("/get")
    public ResponseEntity getEmployees(){
        return ResponseEntity.status(200).body(emps);
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@Valid @RequestBody Employee employee, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        emps.add(employee);
        return ResponseEntity.status(200).body("Employee was added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity addEmployee(@PathVariable String id, @Valid @RequestBody Employee employee, Errors errors){
        int index=-1;
        for (int i=0;i<emps.size();i++) {
            if(emps.get(i).getId().equals(id)){
                index=i;
            }
        }
        if(index==-1){
            return ResponseEntity.status(404).body("Employee with given Id not found!");
        }
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        emps.set(index,employee);
        return ResponseEntity.status(200).body("Employee was updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable String id){
        int index=-1;
        for (int i=0;i<emps.size();i++) {
            if(emps.get(i).getId().equals(id)){
                index=i;
            }
        }
        if(index==-1){
            return ResponseEntity.status(404).body("Employee with given Id not found!");
        }
        emps.remove(index);
        return ResponseEntity.status(200).body("Employee was deleted successfully!");
    }

    @PutMapping("/request/annual/leave/{id}")
    public ResponseEntity requestAnnualLeave(@PathVariable String id){
        int index=-1;
        for (int i=0;i<emps.size();i++) {
            if(emps.get(i).getId().equals(id)){
                index=i;
            }
        }
        if(index==-1){
            return ResponseEntity.status(404).body("Employee with given Id not found!");
        }
        if(emps.get(index).isOnLeave()){
            return ResponseEntity.status(400).body("Bad request");
        }else {
            if(emps.get(index).getAnnualLeave()<1){
                return ResponseEntity.status(400).body("Bad request");
            }else {
                emps.get(index).setOnLeave(true);
                emps.get(index).setAnnualLeave(emps.get(index).getAnnualLeave()-1);
            }
        }
        return ResponseEntity.status(200).body("Annual leave was accepted!");
    }

}
