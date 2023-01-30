package com.example.homework17.Services;

import com.example.homework17.Models.User;
import com.example.homework17.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Boolean updateUser(Integer id, User user){
        User oldUser = userRepository.getById(id);
        if(oldUser ==null){
            return false;
        }
        user.setId(id);
        userRepository.save(user);
        return true;
    }

    public Boolean deleteUser(Integer id){
        User user = userRepository.getById(id);
        if(user ==null){
            return false;
        }
        userRepository.delete(user);
        return true;
    }


}
