package com.example.homework28.repository;

import com.example.homework28.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findAllByMyUserId(Integer userId);

//    Order findOrderByTitle(String title);


}
