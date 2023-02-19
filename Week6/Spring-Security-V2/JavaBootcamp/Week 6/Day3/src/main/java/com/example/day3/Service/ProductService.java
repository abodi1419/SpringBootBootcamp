package com.example.day3.Service;

import com.example.day3.Exception.ApiException;
import com.example.day3.Model.Product;
import com.example.day3.Respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(UUID id, Product product){
        Product oldProduct = productRepository.findProductById(id);
        if (oldProduct == null)
            throw new ApiException("ID not found");

        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        productRepository.save(oldProduct);
    }

    public void deleteProduct(UUID id){
        Product product = productRepository.findProductById(id);
        if (product == null)
            throw new ApiException("ID not found");
        productRepository.delete(product);
    }

    public Product getProductById(UUID id){
        Product product = productRepository.findProductById(id);
        if (product == null)
            throw new ApiException("ID not found");
        return product;
    }


}
