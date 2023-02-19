package com.example.day2.Repository;

import com.example.day2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserById(UUID id);
    User findUserByUsername(String username);
}
