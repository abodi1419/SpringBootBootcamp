package com.example.day4.Controller;

import com.example.day4.ApiResponse;
import com.example.day4.Pojo.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@Valid @RequestBody Employee employee, Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee Added!"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployee(@PathVariable int index, @Valid @RequestBody Employee employee, Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }else if(index >= employees.size() || index < 0){
            return ResponseEntity.status(400).body(new ApiResponse("the index is not valid"));
        }
        employees.set(index,employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee Updated!"));
    }


    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index){
        if(index >= employees.size() || index < 0){
            return ResponseEntity.status(400).body(new ApiResponse("the index is not valid"));
        }
        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Employee Deleted!"));
    }


    @PutMapping("/leave/{index}")
    public ResponseEntity annualLeave(@PathVariable int index){
        if(index >= employees.size() || index <0){
            return ResponseEntity.status(400).body(new ApiResponse("the index is not valid"));
        } else if (employees.get(index).isOnLeave()) {
            return ResponseEntity.status(400).body(new ApiResponse("the employee is already on leave"));
        } else if (employees.get(index).getAnnualLeave() <= 0) {
            return ResponseEntity.status(400).body(new ApiResponse("the employee does not have leave days"));
        }
        Employee employee = employees.get(index);
        employee.setOnLeave(true);
        employee.setAnnualLeave(employee.getAnnualLeave()-1);
        return ResponseEntity.status(200).body(new ApiResponse("Have a nice vacation :)"));
    }
}
