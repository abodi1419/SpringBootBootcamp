package com.example.day3.Respository;

import com.example.day3.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductById(UUID id);
    Product findProductByName(String name);
}
