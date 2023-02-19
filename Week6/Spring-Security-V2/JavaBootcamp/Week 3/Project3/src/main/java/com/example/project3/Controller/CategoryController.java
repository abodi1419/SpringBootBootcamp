package com.example.project3.Controller;

import com.example.project3.Pojo.Category;
import com.example.project3.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategorys(){
        ArrayList<Category> categories = categoryService.getCategories();
        return ResponseEntity.status(200).body(categories);
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Category Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable String id, @Valid @RequestBody Category category, Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        } else if (categoryService.updateCategory(id, category)) {
            return ResponseEntity.status(200).body("Category Was updated");
        }else
            return ResponseEntity.status(400).body("Category Was not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id){
        if(categoryService.deleteCategory(id))
            return ResponseEntity.status(200).body("Category was Deleted");
        else
            return ResponseEntity.status(400).body("Category was not Found");
    }
}
