package com.example.day3.Controller;

import com.example.day3.Model.Order;
import com.example.day3.Model.User;
import com.example.day3.Response;
import com.example.day3.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    
    
    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrders(@AuthenticationPrincipal User user){
        List<Order> orders = orderService.getOrders(user);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping("/{name}/{quan}")
    public ResponseEntity<Response> orderAProduct(@AuthenticationPrincipal User user, @PathVariable String name,@PathVariable int quan){
        orderService.OrderAProduct(user, name, quan);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("order created",200));
    }

    @DeleteMapping()
    public ResponseEntity<Response> deleteOrder(@AuthenticationPrincipal User user, @RequestBody Order order){
        orderService.deleteOrder(user,order.getId());
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Order Deleted!",200));
    }

    @GetMapping("/id")
    public ResponseEntity<Order> getOrder(@AuthenticationPrincipal User user,@RequestBody Order order){
        Order order1 = orderService.getOrderById(user,order.getId());
        return ResponseEntity.status(HttpStatus.OK).body(order1);
    }
}
