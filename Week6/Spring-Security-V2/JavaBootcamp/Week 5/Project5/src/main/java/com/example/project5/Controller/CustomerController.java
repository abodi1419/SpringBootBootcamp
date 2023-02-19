package com.example.project5.Controller;


import com.example.project5.Model.Customer;
import com.example.project5.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity getCustomers(){
        return ResponseEntity.status(200).body(customerService.getCustomers());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Customer Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer was deleted");
    }

    @PutMapping("/assign/{customer_id}/store/{store_id}")
    public ResponseEntity assignCustomerToStore(@PathVariable Integer customer_id, @PathVariable Integer store_id){
        customerService.assignCustomerToStore(customer_id,store_id);
        return ResponseEntity.status(200).body("customer was assigned");
    }
}
