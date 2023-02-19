package com.example.day3.Controller;

import com.example.day3.Model.User;
import com.example.day3.Response;
import com.example.day3.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public ResponseEntity<Response> login(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome",200));
    }

    @GetMapping("/info")
    public ResponseEntity<User> getUserInfo(@AuthenticationPrincipal User user, @RequestBody User id){
        User user1 = userService.getUserById(user,id.getId());
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }
}
