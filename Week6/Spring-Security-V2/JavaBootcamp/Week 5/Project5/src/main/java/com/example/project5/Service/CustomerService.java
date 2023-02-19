package com.example.project5.Service;

import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.CustomerRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final StoreRepository storeRepository;

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer){
        Customer oldCustomer = customerRepository.findCustomerById(id);

        if(oldCustomer == null)
            throw new ApiException("ID not found");

        oldCustomer.setName(customer.getName());
        oldCustomer.setPhone_number(customer.getPhone_number());
        oldCustomer.setEmail(customer.getEmail());
        customerRepository.save(oldCustomer);
    }

    public void deleteCustomer(Integer id){
        Customer customer = customerRepository.findCustomerById(id);

        if (customer == null){
            throw new ApiException("ID not found");
        }

        customerRepository.delete(customer);
    }

    public void assignCustomerToStore(Integer customer_id, Integer store_id){
        Customer customer = customerRepository.findCustomerById(customer_id);
        Store store = storeRepository.findStoreById(store_id);
        if (customer == null || store == null)
            throw new ApiException("ID not found");
        customer.getStores().add(store);
        store.getCustomers().add(customer);
        customerRepository.save(customer);
        storeRepository.save(store);
    }


}
