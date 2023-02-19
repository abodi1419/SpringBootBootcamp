package com.example.day2.Service;

import com.example.day2.Exception.ApiException;
import com.example.day2.Model.User;
import com.example.day2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Wrong Username or Password");
        return user;
    }
    public void register(User user){
        user.setRole("USER");
        String hashed = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashed);
        userRepository.save(user);
    }

    //Only admin can use this endpoint
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    //Only admin can use this endpoint
    public void deleteUser(UUID id){
        User user = userRepository.findUserById(id);
        if(user == null)
            throw new ApiException("ID not found");
        userRepository.delete(user);
    }
}
