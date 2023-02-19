package com.example.homework27;


import com.example.homework27.model.Blog;
import com.example.homework27.model.MyUser;
import com.example.homework27.repository.AuthRepository;
import com.example.homework27.repository.BlogRepository;
import com.example.homework27.service.BlogService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {
    @InjectMocks
    BlogService blogService;
    @Mock
    BlogRepository blogRepository;
    @Mock
    AuthRepository authRepository;

    MyUser user;
    Blog blog1,blog2,blog3;
    List<Blog> blogs ;
    @BeforeEach
    void setUp() {
        user = new MyUser(null,"aziz","123","ADMIN",null);
        blog1 = new Blog(1,"asd1","blog1",user);
        blog2 = new Blog(2,"asd2","blog2",user);
        blog3 = new Blog(3,"asd3","blog3",null);
        authRepository.save(user);
        blogs = new ArrayList<>();
        blogs.add(blog1);
        blogs.add(blog2);
        blogs.add(blog3);
        blogRepository.saveAll(blogs);
    }

    @Test
    public void getAllBlogsTest(){
        when(blogRepository.findAll()).thenReturn(blogs);
        List<Blog> blogList = blogService.getBlogs(user);
        Assertions.assertEquals(3,blogList.size());
        verify(blogRepository, times(1)).findAll();
    }

    @Test
    public void getBlogsByIdTest(){
        when(authRepository.findMyUserById(user.getId())).thenReturn(user);
        when(blogRepository.findBlogsByMyUser(user.getId())).thenReturn(blogs);


        List<Blog> blogList = blogService.getBlogs(user);
        Assertions.assertEquals(blogList,blogs);
        verify(authRepository,times(1)).findMyUserById(user.getId());
        verify(blogRepository,times(1)).findBlogsByMyUser(user.getId());
    }

    @Test
    public void addBlogTest(){
        when(authRepository.findMyUserById(user.getId())).thenReturn(user);
        blogService.addBlog(user, blog3);
        verify(authRepository,times(1)).findMyUserById(user.getId());
        verify(blogRepository,times(1)).save(blog3);
    }

    @Test
    public void updateBlogTest(){
        when(blogRepository.findById(blog1.getId()).get()).thenReturn(blog1);

        blogService.updateBlog(user.getId(), blog1.getId(),blog2);

        verify(blogRepository,times(1)).findById(blog1.getId()).get();
        verify(blogRepository,times(1)).save(blog1);
    }

    @Test
    public void deleteBlogTest(){
        when(blogRepository.findById(blog1.getId()).get()).thenReturn(blog1);

        blogService.removeBlog(user.getId(), blog1.getId());

        verify(blogRepository,times(1)).findById(blog1.getId()).get();
        verify(blogRepository,times(1)).deleteById(blog1.getId());
    }
}
