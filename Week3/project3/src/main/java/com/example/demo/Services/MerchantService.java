package com.example.demo.Services;

import com.example.demo.Pojo.Category;
import com.example.demo.Pojo.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<Merchant> getMerchants(){
        return merchants;
    }

    public Merchant getMerchant(int index){
        return merchants.get(index);
    }
    public int getMerchant(String id){
        for (int i=0; i<merchants.size(); i++){
            if(merchants.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    public void addMerchant(Merchant merchant){
        merchants.add(merchant);
    }

    public boolean updateMerchant(Merchant merchant, String id){
        int index = getMerchant(id);
        if(index>-1) {
            merchants.set(index, merchant);
            return true;
        }
        return false;
    }

    public boolean deleteMerchant(String id){
        int index = getMerchant(id);
        if(index>-1) {
            merchants.remove(index);
            return true;
        }
        return false;
    }


}
