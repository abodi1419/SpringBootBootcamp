package com.example.homework28.contoller;


import com.example.homework28.ApiResponse;
import com.example.homework28.DTO.OrderDTO;
import com.example.homework28.model.MyUser;
import com.example.homework28.model.Order;
import com.example.homework28.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private OrderService orderService;


    @GetMapping()
    public ResponseEntity <List<Order>> getOrders(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(orderService.getOrders(myUser));
    }

    @GetMapping("{orderId}")
    public ResponseEntity <Order> getOrderById(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer orderId){
        return ResponseEntity.status(200).body(orderService.getOrderById(myUser,orderId));
    }
//    @GetMapping("/title")
//    public ResponseEntity <Order> getOrderById(@AuthenticationPrincipal MyUser myUser, @RequestBody Order order){
//        return ResponseEntity.status(200).body(orderService.getOrderByTitle(myUser,order.getTitle()));
//    }

    @PostMapping()
    public ResponseEntity <ApiResponse> addOrders(@AuthenticationPrincipal MyUser myUser, @RequestBody @Valid OrderDTO order){
        orderService.addOrder(myUser,order);
        return ResponseEntity.status(201).body(new ApiResponse("New Order added !",201));
    }

    @DeleteMapping("{orderId}")
    public ResponseEntity <ApiResponse> deleteOrder(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer orderId){
        orderService.removeOrder(myUser.getId(),orderId);
        return ResponseEntity.status(200).body(new ApiResponse("Order deleted !",200));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<ApiResponse> updateOrder(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer orderId, @RequestBody @Valid OrderDTO order){
        orderService.updateOrder(orderId,order);
        return ResponseEntity.status(200).body(new ApiResponse("Order updated !",200));
    }
    @PutMapping("admin/{orderId}")
    public ResponseEntity<ApiResponse> updateOrderStatus(@PathVariable Integer orderId, @RequestBody Order order){
        orderService.changeStatus(orderId,order.getStatus());
        return ResponseEntity.status(200).body(new ApiResponse("Order updated !",200));

    }


}
