package com.example.homework28.service;

import com.example.homework28.DTO.OrderDTO;
import com.example.homework28.Exception.ApiException;
import com.example.homework28.model.MyUser;
import com.example.homework28.model.Order;
import com.example.homework28.model.Product;
import com.example.homework28.repository.OrderRepository;
import com.example.homework28.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

   private final OrderRepository orderRepository;
   private final ProductRepository productRepository;


    public List<Order> getOrders(MyUser myUser) {
        return orderRepository.findAllByMyUserId(myUser.getId());
    }

    public void addOrder(MyUser myUser, OrderDTO orderDTO) {
        if(orderDTO.getProductIds().size() != orderDTO.getQuantities().size()){
            throw new ApiException("You did sometihng wrong!", 400);
        }
        List<Product> products = productRepository.findAllById(orderDTO.getProductIds());
        if(products.contains(null)){
            throw new ApiException("One of products not found",400);
        }
        if(products == null){
            throw new ApiException("Products not found",400);
        }
        Double totalPrice=0.0;
        Integer quantities = 0;
        for (int i=0 ; i<orderDTO.getQuantities().size(); i++){
            totalPrice += products.get(i).getPrice() * orderDTO.getQuantities().get(i);
            quantities+= orderDTO.getQuantities().get(i);
        }
        Order order = new Order();
        order.setTotalPrice(totalPrice);
        order.setQuantity(quantities);
        order.setProducts(products);
        order.setStatus("new");
        order.setDateReceived(new Date());
        order.setMyUser(myUser);
        orderRepository.save(order);
    }

    public void removeOrder(Integer userId, Integer orderId) {
        Order order=orderRepository.findById(orderId).get();

        if(order==null){
            throw new ApiException("Order not found!",404);

        }
        if(order.getMyUser().getId()!=userId){
            throw new ApiException("Unauthorized access!",401);
        }
        if(order.getStatus().equals("inProgress")||order.getStatus().equals("completed")){
            throw new ApiException("Order can not be deleted!",403);
        }
        orderRepository.deleteById(orderId);
    }

    public void updateOrder(Integer orderId, OrderDTO orderDTO) {
        Order oldOrder = orderRepository.findById(orderId).get();
        if(oldOrder.getStatus().equals("inProgress")||oldOrder.getStatus().equals("completed")){
            throw new ApiException("Order can not be updated!",400);
        }
        if(orderDTO.getProductIds().size() != orderDTO.getQuantities().size()){
            throw new ApiException("You did sometihng wrong!", 400);
        }
        List<Product> products = productRepository.findAllById(orderDTO.getProductIds());
        if(products.contains(null)){
            throw new ApiException("One of products not found",400);
        }
        Double totalPrice=0.0;
        Integer quantities = 0;
        for (int i=0 ; i<orderDTO.getQuantities().size(); i++){
            totalPrice += products.get(i).getPrice() * orderDTO.getQuantities().get(i);
            quantities+= orderDTO.getQuantities().get(i);
        }

        oldOrder.setTotalPrice(totalPrice);
        oldOrder.setQuantity(quantities);
        oldOrder.setProducts(products);
        oldOrder.setStatus("new");
        oldOrder.setDateReceived(new Date());

        orderRepository.save(oldOrder);
    }

    public void changeStatus(Integer orderId, String status){
        Order oldOrder = orderRepository.findById(orderId).get();
        if(!status.equals("new")&&!status.equals("inProgress")&&!status.equals("completed")){
            throw new ApiException("Status must be new, inProgress or completed!",400);
        }
        oldOrder.setStatus(status);
        orderRepository.save(oldOrder);

    }

    public Order getOrderById(MyUser myUser, Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        if(order==null){
            throw new ApiException("Order not found.",404);

        }
        if(order.getMyUser().getId()!=myUser.getId()){
            throw new ApiException("You don't own this resource.",401);
        }

        return order;


    }

}
