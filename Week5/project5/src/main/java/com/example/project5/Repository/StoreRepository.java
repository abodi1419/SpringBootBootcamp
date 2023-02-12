package com.example.project5.Repository;


import com.example.project5.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer> {


    Store findStoreById(Integer id);
    List<Store> findStoreByName(String name);



}