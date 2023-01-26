package com.example.demo.Controllers;

import com.example.demo.ApiResponse;
import com.example.demo.Pojo.Category;
import com.example.demo.Services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategories(){
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getCategory(@PathVariable String id){
        int index = categoryService.getCategory(id);
        if(index>-1){
            return ResponseEntity.status(200).body(categoryService.getCategory(index));
        }
        return ResponseEntity.status(404).body(id+" not found!");
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        categoryService.addCategory(product);
        return ResponseEntity.status(200).body("Category Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable String id, @Valid @RequestBody Category product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        boolean isUpdated = categoryService.updateCategory(product,id);
        if(isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Category updated successfully"));
        }else {
            return ResponseEntity.status(404).body(id+" not found!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id){

        boolean isDeleted = categoryService.deleteCategory(id);
        if(isDeleted) {
            return ResponseEntity.status(200).body(id + " deleted!");
        }
        return ResponseEntity.status(404).body(id+" not found!");

    }





}
