package com.example.demo.Services;

import com.example.demo.Pojo.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks(){
        return merchantStocks;
    }

    public MerchantStock getMerchantStock(int index){
        return merchantStocks.get(index);
    }
    public int getMerchantStock(String id){
        for (int i=0; i<merchantStocks.size(); i++){
            if(merchantStocks.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    public void addMerchantStock(MerchantStock product){
        merchantStocks.add(product);
    }

    public int findMerchantStock(String merchantId, String productId){
        for (int i=0; i< merchantStocks.size();i++){
            if (merchantStocks.get(i).getMerchantId().equalsIgnoreCase(merchantId) && merchantStocks.get(i).getProductId().equalsIgnoreCase(productId)){
                return i;
            }
        }
        return -1;
    }
    public void addMerchantStock(String merchantId, String productId,int stock){
        int merchantStock = findMerchantStock(merchantId,productId);
        if(merchantStock!=-1){
            merchantStocks.get(merchantStock).setStock(merchantStocks.get(merchantStock).getStock()+stock);
            return;
        }
        String lastId="501";
        if(merchantStocks.size()>0) {
            lastId = merchantStocks.get(merchantStocks.size() - 1).getId();
            try {
                int id = Integer.parseInt(lastId);
                id++;
                lastId = id + "";
            } catch (NumberFormatException e) {
                System.out.println("Wrong Id");
            }
        }
        merchantStocks.add(new MerchantStock(lastId,productId,merchantId,stock));

    }

    public void decreaseStock( int stock, int index){
        merchantStocks.get(index).setStock((merchantStocks.get(index).getStock()-stock));

    }

    public boolean updateMerchantStock(MerchantStock merchantStock, String id){
        int index = getMerchantStock(id);
        if(index>-1) {
            merchantStocks.set(index, merchantStock);
            return true;
        }
        return false;
    }

    public boolean deleteMerchantStock(String id){
        int index = getMerchantStock(id);
        if(index>-1) {
            merchantStocks.remove(index);
            return true;
        }
        return false;
    }


}
