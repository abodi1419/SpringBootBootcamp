package com.example.day3.Service;

import com.example.day3.Exception.ApiException;
import com.example.day3.Model.User;
import com.example.day3.Respository.UserRepository;
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
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Wrong Username or Password");
        return user;
    }
    public void register(User user){
        user.setRole("CUSTOMER");
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

    public User getUserById(User user,UUID id){
        User user1 = userRepository.findUserById(id);
        if (user1 == null)
            throw new ApiException("ID not found");
        if (user.getRole().equals("ADMIN"))
            return user1;
        if (!(user1.getId().equals(user.getId())))
            throw new ApiException("you are not authorized to view this user");
        return user1;
    }


}
