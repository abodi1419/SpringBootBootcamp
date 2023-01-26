package com.example.demo.Services;

import com.example.demo.Pojo.Merchant;
import com.example.demo.Pojo.MerchantStock;
import com.example.demo.Pojo.Product;
import com.example.demo.Pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    ArrayList<User> users = new ArrayList<>();
    private final MerchantService merchantService;
    private final MerchantStockService merchantStockService;
    private final ProductService productService;

    public ArrayList<User> getUsers(){
        return users;
    }

    public User getUser(int index){
        return users.get(index);
    }
    public int getUser(String id){
        for (int i=0; i<users.size(); i++){
            if(users.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean updateUser(User user, String id){
        int index = getUser(id);
        if(index>-1) {
            users.set(index, user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String id){
        int index = getUser(id);
        if(index>-1) {
            users.remove(index);
            return true;
        }
        return false;
    }

    public ResponseEntity addProductToMerchant(String merchantId, String productId, int stock){
        int merchantIndex = merchantService.getMerchant(merchantId);
        int productIndex = productService.getProduct(productId);
        if(merchantIndex<0){
            return ResponseEntity.status(404).body("Merchant not found!");
        }
        if(productIndex<0){
            return ResponseEntity.status(404).body("Product not found!");
        }
        merchantStockService.addMerchantStock(merchantId,productId,stock);
        return ResponseEntity.status(200).body("Product added to merchant stock!");


    }

    public ResponseEntity buyProduct(String userId, String merchantId, String productId){
        int merchantIndex = merchantService.getMerchant(merchantId);
        int productIndex = productService.getProduct(productId);
        int merchantStockIndex = merchantStockService.findMerchantStock(merchantId,productId);
        int userIndex = getUser(userId);
        if(merchantIndex<0){
            return ResponseEntity.status(404).body("Merchant not found!");
        }
        if(productIndex<0){
            return ResponseEntity.status(404).body("Product not found!");
        }
        if(userIndex<0){
            return ResponseEntity.status(404).body("User not found!");
        }if(merchantStockIndex<0){
            return ResponseEntity.status(404).body("No merchant stock found");
        }

        User user = getUser(userIndex);
        Product product = productService.getProduct(productIndex);
        MerchantStock merchantStock = merchantStockService.getMerchantStock(merchantStockIndex);
        if(merchantStock.getStock()<1){
            return ResponseEntity.status(404).body("No merchant stock found");
        }
        if(user.getBalance()<product.getPrice()){
            return ResponseEntity.status(400).body("You dont have balance");
        }

        user.setBalance(user.getBalance()-product.getPrice());
        merchantStockService.decreaseStock(1,merchantStockIndex);



        return ResponseEntity.status(200).body("Purchased successfully!");
    }


}
