package com.example.demo.Services;

import com.example.demo.Pojo.Merchant;
import com.example.demo.Pojo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts(){
        return products;
    }

    public Product getProduct(int index){
        return products.get(index);
    }
    public int getProduct(String id){
        for (int i=0; i<products.size(); i++){
            if(products.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public boolean updateProduct(Product product, String id){
        int index = getProduct(id);
        if(index>-1) {
            products.set(index, product);
            return true;
        }
        return false;
    }

    public boolean deleteProduct(String id){
        int index = getProduct(id);
        if(index>-1) {
            products.remove(index);
            return true;
        }
        return false;
    }


}
