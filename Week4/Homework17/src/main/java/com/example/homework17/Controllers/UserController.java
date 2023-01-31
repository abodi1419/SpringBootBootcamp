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
    @GetMapping("/get/username/{username}")
    public ResponseEntity getUser(@PathVariable String username){
        User user = userService.findByUsername(username);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getUser(@PathVariable Integer id){
        User user = userService.findById(id);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/get/username/id/{id}")
    public ResponseEntity getUsernameById(@PathVariable Integer id){
        String username = userService.findUsername(id);
        return ResponseEntity.status(200).body(username);
    }
    @PostMapping("/get/email")
    public ResponseEntity getUserByEmail(@RequestBody User user){
        user = userService.findByEmail(user.getEmail());
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user){
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }

    @GetMapping("/get/age/{age}")
    public ResponseEntity addUser(@PathVariable Integer age){

        return ResponseEntity.status(200).body(userService.getUsersByAge(age));
    }

    @GetMapping("/get/role/{role}")
    public ResponseEntity addUser(@PathVariable String role){

        return ResponseEntity.status(200).body(userService.getUsersByRole(role));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        user = userService.login(user.getUsername(),user.getPassword());
        return ResponseEntity.status(200).body(user);
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user){
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("Updated successfully");

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

}
