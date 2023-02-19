package com.example.day2.Controller;

import com.example.day2.Model.User;
import com.example.day2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user){

        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user, Errors errors){
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body("User Updated");

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User was deleted");
    }

    @GetMapping("/check")
    public ResponseEntity checkUsernameAndPassword(@RequestBody User user){
        userService.checkUsernameAndPassword(user.getUsername(),user.getPassword());
        return ResponseEntity.status(200).body("Username and Password are correct");
    }

    @GetMapping("get/email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
        User user = userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/get/role/{role}")
    public ResponseEntity getUsersByRole(@PathVariable String role){
        List<User> users = userService.getUserByRole(role);
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/get/age/{age}")
    public ResponseEntity getUsersAgeOrAbove(@PathVariable int age){
        List<User> users = userService.findUsersByAgeGreaterThanEqual(age);
        return ResponseEntity.status(200).body(users);
    }



}
