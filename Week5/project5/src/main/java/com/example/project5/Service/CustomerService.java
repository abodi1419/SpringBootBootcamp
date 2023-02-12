package com.example.project5.Service;


import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.BookRepository;
import com.example.project5.Repository.CustomerRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
   private final StoreService storeService;
   private final StoreRepository storeRepository;



    public Customer findById(Integer id){
        Customer customer = customerRepository.findCustomerById(id);
        if(customer ==null){
            throw new ApiException("Customer not found!", 404);
        }
        return customer;
    }
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void attach(Integer customer_id, Integer store_id){
        Customer customer = findById(customer_id);
        Store store = storeService.findById(store_id);
        customer.getStores().add(store);
        store.getCustomers().add(customer);
        customerRepository.save(customer);
        storeRepository.save(store);
    }

    public void detach(Integer customer_id, Integer store_id){
        Customer customer = findById(customer_id);
        Store store = storeService.findById(store_id);
        customer.getStores().remove(store);
        store.getCustomers().remove(customer);
        customerRepository.save(customer);
        storeRepository.save(store);
    }
//    public String getTeacherName(Integer customer_id){
//        Customer customer = findById(customer_id);
//        Store teacher = customer.getStore();
//        if(teacher==null){
//            return "null";
//        }
//        return teacher.getName();
//
//    }

    public void deleteCustomer(Integer customer_id){
        Customer customer = findById(customer_id);
        customerRepository.delete(customer);

    }



//    public Director findById(Integer id){
//        Director director =directorRepository.findDirectorById(id);
//        if(director==null){
//            throw new ApiException("Director not found",404);
//        }
//        return director;
//    }
//
//
//
    public void updateCustomer(Integer id, Customer customer){
        Customer oldCustomer = findById(id);
        oldCustomer.setName(customer.getName());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPhone(customer.getPhone());
        customerRepository.save(oldCustomer);
    }
    

//    public void deleteAddress(Integer id){
//        Location address = addressRepository.findAddressById(id);
//        if(address ==null){
//            throw new ApiException("Location not found!",404);
//        }
//        addressRepository.delete(address);
//    }
//
//
//
//    public List<Director> getDirectorsByName(String name){
//        List<Director> directors = directorRepository.findDirectorsByNameIsLike(name);
//        if(directors.isEmpty()){
//            throw new ApiException("No directors found with name provided! ",404);
//        }
//        return directors;
//    }


}
