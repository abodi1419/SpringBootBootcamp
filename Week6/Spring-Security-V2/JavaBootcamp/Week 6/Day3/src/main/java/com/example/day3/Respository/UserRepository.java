package com.example.day3.Respository;

import com.example.day3.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserById(UUID id);
    User findUserByUsername(String username);
}
