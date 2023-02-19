package com.example.day3.Controller;

import com.example.day3.Pojo.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank/customers")
public class CustomerController {

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
        customers.add(customer);

        return "Customer Added";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestParam String id, @RequestBody Customer customer){
        for (Customer c:customers) {
            if(c.getId().equals(id)){
                c.setId(customer.getId());
                c.setUsername(customer.getUsername());
                c.setBalance(customer.getBalance());
                return "Customer updated";
            }
        }

        return "id was not found";
    }


    @DeleteMapping("/delete")
    public String deleteCustomer(@RequestParam String id){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId().equals(id)){
                customers.remove(i);
                return "Customer Deleted";
            }
        }
        return "id wasn't found";
    }

    @PutMapping("/deposit")
    public String deposit(@RequestParam double amount, @RequestParam String id){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId().equals(id)){
                double newBalance = customers.get(i).getBalance()+amount;
                customers.get(i).setBalance(newBalance);
                return amount+"SR was added to your balance";
            }
        }
        return "id wasn't found";
    }


    @PutMapping("/withdraw")
    public String withdraw(@RequestParam double amount, @RequestParam String id){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId().equals(id)){
                if(customers.get(i).getBalance() > amount){
                    double newBalance = customers.get(i).getBalance() - amount;
                    customers.get(i).setBalance(newBalance);
                    return "your new balance is " + newBalance+"SR";
                }
                return "insufficient balance";
            }
        }
        return "id wasn't found";
    }


}
