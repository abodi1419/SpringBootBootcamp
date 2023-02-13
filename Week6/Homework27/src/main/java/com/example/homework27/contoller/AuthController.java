package com.example.homework27.contoller;


import com.example.homework27.ApiResponse;
import com.example.homework27.model.MyUser;
import com.example.homework27.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;


    @GetMapping
    public ResponseEntity<MyUser> getUser(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authService.getUser(myUser));
    }

    @PutMapping
    public ResponseEntity<ApiResponse> getUser(@AuthenticationPrincipal MyUser myUser,@RequestBody MyUser myUser1){
        authService.updateUser(myUser,myUser1);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("Updated successfully",201));
    }
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody MyUser myUser){
        authService.register(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("User registered!",201));
    }

    @PostMapping("/user")
    public ResponseEntity<ApiResponse> user(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back user",200));
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back",200));
    }
}
