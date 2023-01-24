package com.example.homework13;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/customers")
public class MainController {
    ArrayList<Customer> customers = new ArrayList<>();
    int id =1;

    @GetMapping("/get")
    public ArrayList<Customer> get(){
        return customers;
    }

    @PostMapping("/add")
    public String add(@RequestBody Customer task){
        task.setId(id+"");
        id++;
        customers.add(task);
        return task.getUsername();
    }

    @PutMapping("/update/{id}")
    public String updateTask(@PathVariable String id, @RequestBody Customer customer){
        for (Customer myCustomer : customers) {
            if(myCustomer.getId().equals(id)){
                myCustomer.setUsername(customer.getUsername());
                myCustomer.setBalance(customer.getBalance());
            }
        }
        return "Updated!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable String id){
        for (int i=0; i<customers.size();i++){
            if(customers.get(i).getId().equals(id)){
                customers.remove(i);
                return "Deleted!";
            }
        }
        return "Not found so not deleted!";
    }


    @PostMapping("deposit/{id}")
    public String deposit(@PathVariable String id,@RequestParam double money){
        for (int i=0; i<customers.size();i++){
            if(customers.get(i).getId().equals(id)){
                return customers.get(i).deposit(money)+"";
            }
        }
        return "Not found!";
    }

    @PostMapping("withdraw/{id}")
    public String withdraw(@PathVariable String id,@RequestParam double money){
        for (int i=0; i<customers.size();i++){
            if(customers.get(i).getId().equals(id)){
                return customers.get(i).withdraw(money)+"";
            }
        }
        return "Not found!";
    }
}
