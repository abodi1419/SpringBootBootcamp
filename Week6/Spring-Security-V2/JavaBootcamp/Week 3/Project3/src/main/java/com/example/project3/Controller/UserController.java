package com.example.project3.Controller;


import com.example.project3.ApiResponse;
import com.example.project3.Pojo.User;
import com.example.project3.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        ArrayList<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable String id, @Valid @RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        } else if (userService.updateUser(id, user)) {
            return ResponseEntity.status(200).body("User Was updated");
        }else
            return ResponseEntity.status(400).body("User Was not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        if(userService.deleteUser(id))
            return ResponseEntity.status(200).body("User was Deleted");
        else
            return ResponseEntity.status(400).body("User was not Found");
    }

    @PutMapping("/stock/add/{merchantId}/{productId}/{stock}")
    public ResponseEntity addStock(@PathVariable String merchantId, @PathVariable String productId, @PathVariable int stock){
        ApiResponse response = userService.addStock(productId,merchantId, stock);
        return ResponseEntity.status(response.getStatus()).body(response.getMessage());
    }

    @PutMapping("/buy/{userId}/{merchantId}/{productId}/{productQuantity}")
    public ResponseEntity buyProduct(@PathVariable String userId, @PathVariable String merchantId, @PathVariable String productId, @PathVariable int productQuantity){
        ApiResponse response = userService.buyProduct(userId, productId,merchantId, productQuantity);
        return ResponseEntity.status(response.getStatus()).body(response.getMessage());
    }

}
