package com.example.project5.Service;



import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {
    private final StoreRepository storeRepository;


    public List<Store> getStores(){
        return storeRepository.findAll();
    }

    public void addStore(Store store){
        storeRepository.save(store);
    }

    public Store findById(Integer id){
        Store store = storeRepository.findStoreById(id);
        if(store ==null){
            throw new ApiException("Store not found",404);
        }
        return store;
    }



    public void updateStore(Integer id, Store store){
        Store oldStore = findById(id);
        store.setId(id);
        storeRepository.save(store);
    }

    public void deleteStore(Integer id){
        Store store = findById(id);
        storeRepository.delete(store);
    }


    public List<Store> getStoresByName(String name){
        List<Store> stores = storeRepository.findStoreByName(name);
        if(stores.isEmpty()){
            throw new ApiException("No stores found with name provided! ",404);
        }
        return stores;
    }

    public List<Book> getBooks(Integer storeId){
        Store store = findById(storeId);
        return store.getBooks();
    }

    public List<Customer> getCustomers(Integer storeId){
        Store store = findById(storeId);
        return store.getCustomers();
    }



}
