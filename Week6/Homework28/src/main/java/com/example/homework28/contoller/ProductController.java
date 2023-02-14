package com.example.homework28.contoller;


import com.example.homework28.ApiResponse;
import com.example.homework28.model.Product;
import com.example.homework28.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.status(200).body(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody @Valid Product product){
        productService.addProduct(product);
        return ResponseEntity.status(200).body(new ApiResponse("Added successfully!",200));
    }

    @PutMapping("admin/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Integer id,@RequestBody @Valid Product product){
        productService.updateProduct(id,product);
        return ResponseEntity.status(200).body(new ApiResponse("Added successfully!",200));
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> addProduct(@PathVariable Integer id){
        return ResponseEntity.status(200).body(productService.getProductById(id));
    }
}
