package com.example.springsecurity;

import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthRepositoryTest {
    @Autowired
    AuthRepository authRepository;

    MyUser user;

    @BeforeEach
    void setUp() {
        user = new MyUser(null,"Abdullah","123","ADMIN",null);
    }

    @Test
    public void findMyUserByIdTest(){
        authRepository.save(user);
        MyUser user1=authRepository.findById(user.getId()).get();
        Assertions.assertThat(user1).isEqualTo(user);
    }

    @Test
    public void findMyUserByUserNameTest(){
        authRepository.save(user);
        MyUser user1=authRepository.findMyUserByUsername(user.getUsername());
        Assertions.assertThat(user1).isEqualTo(user);
    }
}
