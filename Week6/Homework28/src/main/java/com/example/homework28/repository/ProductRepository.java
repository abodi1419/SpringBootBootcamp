package com.example.homework28.repository;

import com.example.homework28.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductById(Integer id);

//    List<Product> findAllById(List<Integer> ids);

    Product findProductByName(String name);
}
