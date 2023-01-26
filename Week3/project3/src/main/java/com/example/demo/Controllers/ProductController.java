package com.example.demo.Controllers;

import com.example.demo.ApiResponse;
import com.example.demo.Pojo.Product;
import com.example.demo.Pojo.User;
import com.example.demo.Services.ProductService;
import com.example.demo.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getProducts(){
        return ResponseEntity.status(200).body(productService.getProducts());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getProduct(@PathVariable String id){
        int index = productService.getProduct(id);
        if(index>-1){
            return ResponseEntity.status(200).body(productService.getProduct(index));
        }
        return ResponseEntity.status(404).body(id+" not found!");
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body("Product Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @Valid @RequestBody Product product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        boolean isUpdated = productService.updateProduct(product,id);
        if(isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Product updated successfully"));
        }else {
            return ResponseEntity.status(404).body(id+" not found!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){

        boolean isDeleted = productService.deleteProduct(id);
        if(isDeleted) {
            return ResponseEntity.status(200).body(id + " deleted!");
        }
        return ResponseEntity.status(404).body(id+" not found!");

    }





}
