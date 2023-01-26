package com.example.demo.Controllers;

import com.example.demo.ApiResponse;
import com.example.demo.Services.UserService;
import com.example.demo.Pojo.User;
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
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getUser(@PathVariable String id){
        int index = userService.getUser(id);
        if(index>-1){
            return ResponseEntity.status(200).body(userService.getUser(index));
        }
        return ResponseEntity.status(404).body(id+" not found!");
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity addUser(@PathVariable String id, @Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        boolean isUpdated = userService.updateUser(user,id);
        if(isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("User updated successfully"));
        }else {
            return ResponseEntity.status(404).body(id+" not found!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){

        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted) {
            return ResponseEntity.status(200).body(id + " deleted!");
        }
        return ResponseEntity.status(404).body(id+" not found!");

    }

    @PutMapping("/add/product/merchant/{productId}/{merchantId}/{stock}")
    public ResponseEntity addProductToMerchant(@PathVariable String productId, @PathVariable String merchantId, @PathVariable int stock){
        return userService.addProductToMerchant(merchantId,productId,stock);
    }

    @PutMapping("/buy/product/merchant/{userId}/{merchantId}/{productId}")
    public ResponseEntity addProductToMerchant( @PathVariable String userId ,@PathVariable String productId, @PathVariable String merchantId){
        return userService.buyProduct( userId,merchantId,productId);
    }







}
