package com.example.project5.Service;

import com.example.project5.DTO.LocationDTO;
import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.LocationRepository;
import com.example.project5.Repository.StoreRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<Store> getStores(){
        return storeRepository.findAll();
    }

    public void addStore(Store store){
        storeRepository.save(store);
    }

    public void updateStore(Integer id, Store store){
        Store oldStore = storeRepository.findStoreById(id);

        if(oldStore == null)
            throw new ApiException("ID not found");

        oldStore.setName(store.getName());
        storeRepository.save(oldStore);
    }

    public void deleteStore(Integer id){
        Store store = storeRepository.findStoreById(id);

        if (store == null){
            throw new ApiException("ID not found");
        }

        storeRepository.delete(store);
    }

    public List<Book> getStoreBooks(Integer id){
        Store store = storeRepository.findStoreById(id);
        if(store == null)
            throw new ApiException("ID not found");
        return store.getBooks();
    }

    public List<Customer> getStoreCustomers(Integer id){
        Store store = storeRepository.findStoreById(id);
        if(store == null)
            throw new ApiException("ID not found");
        return store.getCustomers();
    }




}
