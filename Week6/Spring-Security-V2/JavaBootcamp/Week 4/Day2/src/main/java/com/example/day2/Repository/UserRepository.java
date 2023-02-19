package com.example.day2.Repository;

import com.example.day2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    User findUserByUsernameAndPassword(String username, String password);

    User findUserByEmail(String email);

    List<User> findUsersByRole(String role);

    @Query("select u from User u where u.age >= ?1")
    List<User> findUsersByAgeGreaterThanEqual(int age);
}
