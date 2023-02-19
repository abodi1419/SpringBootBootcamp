package com.example.project5.Controller;

import com.example.project5.DTO.LocationDTO;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.StoreRepository;
import com.example.project5.Service.LocationService;
import com.example.project5.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    private final LocationService locationService;

    @GetMapping("/all")
    public ResponseEntity getStores(){
        return ResponseEntity.status(200).body(storeService.getStores());
    }

    @PostMapping("/add")
    public ResponseEntity addStore(@Valid @RequestBody Store store){
        storeService.addStore(store);
        return ResponseEntity.status(200).body("Store Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStore(@PathVariable Integer id, @Valid @RequestBody Store store){
        storeService.updateStore(id, store);
        return ResponseEntity.status(200).body("Store Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id){
        storeService.deleteStore(id);
        return ResponseEntity.status(200).body("Store was deleted");
    }


    @GetMapping("/locations")
    public ResponseEntity getLocations(){
        return ResponseEntity.status(200).body(locationService.getLocations());
    }

    @PostMapping("/location/add")
    public ResponseEntity addStoreLocation(@Valid @RequestBody LocationDTO dto){
        locationService.addStoreLocation(dto);
        return ResponseEntity.status(200).body("Store Location Added");
    }

    @PutMapping("/location/update")
    public ResponseEntity updateStoreLocation(@Valid @RequestBody LocationDTO dto){
        locationService.updateStoreLocation(dto);
        return ResponseEntity.status(200).body("Store Location Updated");
    }

    @DeleteMapping("/location/delete/{id}")
    public ResponseEntity deleteStoreLocation(@PathVariable Integer id){
        locationService.deleteStoreLocation(id);
        return ResponseEntity.status(200).body("Store Location was deleted");
    }

    @GetMapping("/books/{id}")
    public ResponseEntity getBooks(@PathVariable Integer id){
        List<Book> books = storeService.getStoreBooks(id);
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomers(@PathVariable Integer id){
        List<Customer> customers = storeService.getStoreCustomers(id);
        return ResponseEntity.status(200).body(customers);
    }


}
