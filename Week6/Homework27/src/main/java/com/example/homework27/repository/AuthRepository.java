package com.example.homework27.repository;

import com.example.homework27.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository  extends JpaRepository<MyUser,Integer> {

    MyUser findMyUserByUsername(String username);

    MyUser findMyUserById(Integer id);
}
