package com.example.homework27;



import com.example.homework27.model.Blog;
import com.example.homework27.model.MyUser;
import com.example.homework27.repository.AuthRepository;
import com.example.homework27.repository.BlogRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BlogRepositoryTest {


    @Autowired
    BlogRepository blogRepository;

    @Autowired
    AuthRepository myUserRepository;

    Blog blog1,blog2,blog3;
    MyUser myUser;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Abdullah" , "12345" , "ADMIN" ,null);
//        myUserRepository.save(myUser);
        blog1 = new Blog(null,"blog1", "body1" , myUser );
        blog2 = new Blog(null,"blog2", "body2" , myUser );
        blog3 = new Blog(null,"blog3", "body3" , myUser );
    }


    @Test
    public void findAllByMyUserTesting(){
        myUserRepository.save(myUser);
        blogRepository.save(blog1);
        blogRepository.save(blog2);
        blogRepository.save(blog3);

        List<Blog> blogs = blogRepository.findBlogsByMyUser(myUser.getId());
        Assertions.assertThat(blogs.get(0).getMyUser().getId()).isEqualTo(myUser.getId());
    }

    @Test
    public void findBlogById(){
        blogRepository.save(blog1);
        Blog blog=blogRepository.findById(blog1.getId()).get();
        Assertions.assertThat(blog).isEqualTo(blog1);
    }


}
