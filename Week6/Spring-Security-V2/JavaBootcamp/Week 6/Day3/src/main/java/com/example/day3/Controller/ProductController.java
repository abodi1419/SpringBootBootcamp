package com.example.day3.Controller;


import com.example.day3.Model.Product;
import com.example.day3.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/id")
    public ResponseEntity<Product> getProduct(@RequestBody Product id){
        Product product = productService.getProductById(id.getId());
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }


}
