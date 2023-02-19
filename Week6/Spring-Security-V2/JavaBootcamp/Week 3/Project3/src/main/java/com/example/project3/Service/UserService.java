package com.example.project3.Service;

import com.example.project3.ApiResponse;
import com.example.project3.Pojo.Merchant;
import com.example.project3.Pojo.MerchantStock;
import com.example.project3.Pojo.Product;
import com.example.project3.Pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

    ArrayList<User> users = new ArrayList<>();

    private final MerchantStockService merchantStockService;
    private final ProductService productService;
    private final MerchantService merchantService;

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean updateUser(String id, User user){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(String id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public ApiResponse addStock(String productId, String merchantId, int stock){
        for (int i = 0; i < merchantStockService.merchantStocks.size(); i++) {
            if (merchantStockService.merchantStocks.get(i).getProductId().equals(productId) &&
                merchantStockService.merchantStocks.get(i).getMerchantId().equals(merchantId)){

                int newStock = merchantStockService.merchantStocks.get(i).getStock() + stock;
                merchantStockService.merchantStocks.get(i).setStock(newStock);

                return new ApiResponse(200, "Stock was added");
            }
        }
        return new ApiResponse(400, "product ID or merchant ID was not found");
    }


    public ApiResponse buyProduct(String userId, String productId, String merchantId, int productQuantity){

        //check if the user exists
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(userId)){
                user = users.get(i);
                break;
            }
        }
        if(user == null)
            return new ApiResponse(400, "The user was not found");


        //check if the product exists
        Product product = null;
        for (int i = 0; i < productService.getProducts().size(); i++) {
            if(productService.getProducts().get(i).getId().equals(productId)){
                product = productService.getProducts().get(i);
                break;
            }
        }
        if (product == null)
            return new ApiResponse(400, "The product was not found");

        //check if the user has sufficient balance
        if(user.getBalance() <= (product.getPrice()*productQuantity))
            return new ApiResponse(400, "The user does not have sufficient balance");

        //check if the merchant exists
        Merchant merchant = null;
        for (int i = 0; i < merchantService.getMerchants().size(); i++) {
            if (merchantService.getMerchants().get(i).getId().equals(merchantId)){
                merchant = merchantService.getMerchants().get(i);
                break;
            }
        }
        if(merchant == null)
            return new ApiResponse(400, "The merchant was not found");

        //check if there is enough stock
        for (int i = 0; i < merchantStockService.getMerchantStocks().size(); i++) {
            if (merchantStockService.getMerchantStocks().get(i).getProductId().equals(productId) &&
                merchantStockService.getMerchantStocks().get(i).getMerchantId().equals(merchantId) &&
                merchantStockService.getMerchantStocks().get(i).getStock() >= productQuantity){

                int newStock = merchantStockService.getMerchantStocks().get(i).getStock() - productQuantity;
                merchantStockService.getMerchantStocks().get(i).setStock(newStock);
                return new ApiResponse(200, "successful purchase");
            }
        }


        return new ApiResponse(400, "There isn't enough stock");
    }



}
