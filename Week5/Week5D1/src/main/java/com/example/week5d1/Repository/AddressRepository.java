package com.example.week5d1.Repository;

import com.example.week5d1.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);
}