package com.example.homework28.service;


import com.example.homework28.Exception.ApiException;
import com.example.homework28.model.MyUser;
import com.example.homework28.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;


    public void register(MyUser myUser) {
        myUser.setRole("CUSTOMER");
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        authRepository.save(myUser);
    }

    public MyUser getUser(MyUser myUser) {
        MyUser myUser1 = authRepository.findById(myUser.getId()).get();
        if(myUser1==null){
            throw new ApiException("User not found",404);
        }

        return myUser1;
    }

    public void updateUser(MyUser myUser, MyUser myUser1) {
        if(myUser1.getUsername()!=null) {
            myUser.setUsername(myUser1.getUsername());
        }
        if(myUser1.getPassword()!=null) {
            String hashedPassword = new BCryptPasswordEncoder().encode(myUser1.getPassword());
            myUser.setPassword(hashedPassword);
        }
        authRepository.save(myUser);
    }
}
