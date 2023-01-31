package com.example.homework17.Services;

import com.example.homework17.Exception.ApiException;
import com.example.homework17.Models.User;
import com.example.homework17.Repositories.UserRepository;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.metamodel.Metamodel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;


    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public User findById(Integer id){
        User user = userRepository.findUserById(id);
        if(user==null){
            throw new ApiException("User not found",404);
        }
        return user;
    }

    public User findByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        if(user==null){
            throw new ApiException("User not found",404);
        }
        return user;
    }

    public String findUsername(Integer id){
        String user = userRepository.findUserName(id);
        if(user==null){
            throw new ApiException("User not found!",404);
        }
        return user;
    }

    public void updateUser(Integer id, User user){
        User oldUser = userRepository.findUserById(id);
        if(oldUser ==null){
            throw new ApiException("User not found!",404);
        }
        user.setId(id);
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        User user = userRepository.findUserById(id);
        if(user ==null){
            throw new ApiException("User not found!",404);
        }
        userRepository.delete(user);
    }

    public User findByUsername(String username){
        User user = userRepository.findUserByUsername(username);
        if(user==null){
            throw new ApiException("User not found!",404);
        }
        return user;
    }

    public User login(String username, String password){
        User user = userRepository.findUserByUsernameAndPassword(username,password);
        if(user==null){
            throw new ApiException("Bad credentials!",403);
        }
        return user;
    }

    public List<User> getUsersByAge(Integer age){
        List<User> users = userRepository.findUsersByAgeGreaterThanEqual(age);
        if(users.isEmpty()){
            throw new ApiException("No users above or equal age provided! ",404);
        }
        return users;
    }
    public List<User> getUsersByRole(String role){
        List<User> users = userRepository.findUsersByRole(role);
        if(users.isEmpty()){
            throw new ApiException("No users found with provided role! ",404);
        }
        return users;
    }


}
