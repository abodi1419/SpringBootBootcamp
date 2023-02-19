package com.example.project3.Controller;

import com.example.project3.Pojo.Product;
import com.example.project3.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/get")
    public ResponseEntity getProducts(){
        ArrayList<Product> products = productService.getProducts();
        return ResponseEntity.status(200).body(products);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body("Product Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @Valid @RequestBody Product product, Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        } else if (productService.updateProduct(id, product)) {
            return ResponseEntity.status(200).body("Product Was updated");
        }else
            return ResponseEntity.status(400).body("Product Was not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        if(productService.deleteProduct(id))
            return ResponseEntity.status(200).body("Product was Deleted");
        else
            return ResponseEntity.status(400).body("Product was not Found");
    }


}
