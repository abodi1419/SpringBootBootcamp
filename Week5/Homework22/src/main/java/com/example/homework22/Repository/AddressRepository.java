package com.example.homework22.Repository;


import com.example.homework22.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);
}