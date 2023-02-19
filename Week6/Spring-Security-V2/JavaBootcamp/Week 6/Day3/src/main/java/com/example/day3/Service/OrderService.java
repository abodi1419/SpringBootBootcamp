package com.example.day3.Service;

import com.example.day3.Exception.ApiException;
import com.example.day3.Model.Order;
import com.example.day3.Model.Product;
import com.example.day3.Model.User;
import com.example.day3.Respository.OrderRepository;
import com.example.day3.Respository.ProductRepository;
import com.example.day3.Respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public List<Order> getOrders(User user){
        return userRepository.findUserById(user.getId()).getOrders();
    }

    public void OrderAProduct(User user, String productName, int quantity){
        Product product = productRepository.findProductByName(productName);
        if (product == null)
            throw new ApiException("Product not found");

        Order order = new Order(null,(quantity*product.getPrice()),new Date(),quantity,"new",user,product);
        orderRepository.save(order);
    }

    public void updateOrderStatus(UUID id, String status){
        Order order = orderRepository.findOrderById(id);
        if (order == null)
            throw new ApiException("ID not found");
        order.setStatus(status);
        orderRepository.save(order);
    }

    public void deleteOrder(User user, UUID order_id){
        Order order = orderRepository.findOrderById(order_id);
        if (order == null)
            throw new ApiException("ID not found");
        if (!(order.getUser().getId().equals(user.getId())))
            throw new ApiException("You are not authorized to delete this order");
        if (!(order.getStatus().equals("new")))
            throw new ApiException("you cannot delete the order because the order is " + order.getStatus());
        orderRepository.delete(order);
    }

    public Order getOrderById(User user,UUID id){
        Order order = orderRepository.findOrderById(id);
        if (order == null)
            throw new ApiException("ID not found");
        if (user.getRole().equals("ADMIN"))
            return order;
        if (!(order.getUser().getId().equals(user.getId())))
            throw new ApiException("You are not authorized to view this order");
        return order;
    }


}
