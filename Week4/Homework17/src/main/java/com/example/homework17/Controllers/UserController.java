package com.example.homework17.Controllers;

import com.example.homework17.Models.User;
import com.example.homework17.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdated = userService.updateUser(id, user);
        if(isUpdated){
            return ResponseEntity.status(200).body("Updated successfully");
        }else {
            return ResponseEntity.status(404).body("User not found!");
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        Boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("Deleted successfully");
        }else {
            return ResponseEntity.status(404).body("User not found!");
        }
    }

}
