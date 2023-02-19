package com.example.day3.Controller;


import com.example.day3.Model.Order;
import com.example.day3.Model.Product;
import com.example.day3.Model.User;
import com.example.day3.Response;
import com.example.day3.Service.OrderService;
import com.example.day3.Service.ProductService;
import com.example.day3.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @DeleteMapping("/user/delete")
    public ResponseEntity<Response> deleteUser(@RequestBody User user){
        userService.deleteUser(user.getId());
        return ResponseEntity.status(HttpStatus.OK).body(new Response("User Deleted!",200));
    }
    @PostMapping("/product/add")
    public ResponseEntity<Response> addProducts(@Valid @RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Product added!",201));
    }

    @DeleteMapping("/product/delete")
    public ResponseEntity<Response> deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product.getId());
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Product Deleted!",200));
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity<Response> updateProduct(@PathVariable UUID id, @Valid @RequestBody Product product){
        productService.updateProduct(id, product);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Product Updated!",200));
    }

    @PutMapping("/order/update/{status}")
    public ResponseEntity<Response> updateOrderStatus(@PathVariable String status, @RequestBody Order order){
        orderService.updateOrderStatus(order.getId(),status);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Status Updated!",200));
    }

}
