package com.example.springsecurity;

import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import com.example.springsecurity.repository.TodoRepository;
import com.example.springsecurity.service.AuthService;
import com.example.springsecurity.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @InjectMocks
    AuthService authService;
    @Mock
    AuthRepository authRepository;

    MyUser user;
    MyUser user1;

    @BeforeEach
    void setUp() {
        user = new MyUser(null,"aziz","123","ADMIN",null);
        user1 = new MyUser(null,"khalid","123","CUSTOMER",null);
    }

    @Test
    public void registerTest(){
        authService.register(user);
        verify(authRepository,times(1)).save(user);
    }
}
