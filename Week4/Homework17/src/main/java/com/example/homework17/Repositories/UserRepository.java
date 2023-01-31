package com.example.homework17.Repositories;

import com.example.homework17.Models.User;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);
    User findUserById(Integer id);
    User findUserByEmail(String email);

    @Query("select u.username from User u where u.id=?1")
    String findUserName(Integer id);


    User findUserByUsernameAndPassword(String username, String password);

    List<User> findUsersByAgeGreaterThanEqual(Integer age);
    List<User> findUsersByRole(String role);



}