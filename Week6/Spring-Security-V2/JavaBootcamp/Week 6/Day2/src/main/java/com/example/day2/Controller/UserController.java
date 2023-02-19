package com.example.day2.Controller;

import com.example.day2.Model.Blog;
import com.example.day2.Model.User;
import com.example.day2.Response;
import com.example.day2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<Response> register(@Valid @RequestBody User user){
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("User registered !",201));
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<Response> deleteUser(@RequestBody User user){
        userService.deleteUser(user.getId());
        return ResponseEntity.status(HttpStatus.OK).body(new Response("User Deleted!",200));
    }


    @PostMapping("/login")
    public ResponseEntity<Response> login(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome",200));
    }


}
