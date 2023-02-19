package com.example.day2.Service;

import com.example.day2.Exception.ApiException;
import com.example.day2.Model.User;
import com.example.day2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user){
        User oldUser = userRepository.findById(id).orElse(null);

        if(oldUser == null)
            throw new ApiException("ID was not found");

        user.setId(id);
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        User user = userRepository.findById(id).orElse(null);

        if (user == null){
            throw new ApiException("ID was not found");
        }

        userRepository.delete(user);
    }


    public void checkUsernameAndPassword(String username, String password){
        User user = userRepository.findUserByUsernameAndPassword(username,password);

        if(user == null)
            throw new ApiException("Username and Password are not correct");
    }

    public User findUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);

        if (user == null)
            throw new ApiException("Email Was not found");

        return user;
    }

    public List<User> getUserByRole(String role){
        List<User> users = userRepository.findUsersByRole(role);

        if (users.isEmpty())
            throw new ApiException("There is no users that have the " + role + " role");

        return users;
    }

    public List<User> findUsersByAgeGreaterThanEqual(int age){
        List<User> users = userRepository.findUsersByAgeGreaterThanEqual(age);

        if (users.isEmpty())
            throw new ApiException("There is no users that are " + age + " or above");

        return users;
    }



}
