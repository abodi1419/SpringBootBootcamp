package com.example.homework28.service;

import com.example.homework28.Exception.ApiException;
import com.example.homework28.model.MyUser;
import com.example.homework28.model.Product;
import com.example.homework28.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProduct(Integer productId) {
        Product product=productRepository.findById(productId).get();


        if(product==null){
            throw new ApiException("Product not found!",404);

        }
        productRepository.deleteById(productId);
    }

    public void updateProduct(Integer productId, Product product) {
        Product oldProduct = productRepository.findById(productId).get();
        if(oldProduct==null){
            throw new ApiException("Product not found!",404);
        }

        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        productRepository.save(oldProduct);
    }

    public Product getProductById(Integer productId) {
        Product product = productRepository.findProductById(productId);
        if(product==null){
            throw new ApiException("Product not found.",404);
        }
        return product;


    }

    public Product getProductByName(String title) {

        Product product = productRepository.findProductByName(title);
        if(product==null){
            throw new ApiException("Product not found.",404);
        }
        return product;

    }
}
