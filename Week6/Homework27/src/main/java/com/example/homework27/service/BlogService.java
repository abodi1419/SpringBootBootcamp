package com.example.homework27.service;


import com.example.homework27.Exception.ApiException;
import com.example.homework27.model.Blog;
import com.example.homework27.model.MyUser;
import com.example.homework27.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

   private final BlogRepository blogRepository;


    public List<Blog> getBlogs(MyUser myUser) {
        return blogRepository.findAllByMyUserId(myUser.getId());
    }

    public void addBlog(MyUser myUser,Blog blog) {
        blog.setMyUser(myUser);
        blogRepository.save(blog);
    }

    public void removeBlog(Integer userId, Integer blogId) {
        Blog blog=blogRepository.findById(blogId).get();

        if(blog==null){
            throw new ApiException("Blog not found!",404);

        }
        if(blog.getMyUser().getId()!=userId){
            throw new ApiException("Unauthorized access!",401);
        }

        blogRepository.deleteById(blogId);
    }

    public void updateBlog(Integer userId,Integer blogId, Blog blog) {
        Blog oldBlog = blogRepository.findById(blogId).get();
        if(oldBlog==null){
            throw new ApiException("Blog not found!",404);

        }
        if(oldBlog.getMyUser().getId()!=userId){
            throw new ApiException("Unauthorized access!",401);
        }


        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());
        blogRepository.save(oldBlog);
    }

    public Blog getBlogById(MyUser myUser, Integer blogId) {
        Blog blog = blogRepository.findById(blogId).get();
        if(blog==null){
            throw new ApiException("Blog not found.",404);

        }
        if(blog.getMyUser().getId()!=myUser.getId()){
            throw new ApiException("You don't own this resource.",401);
        }

        return blog;


    }

    public Blog getBlogByTitle(MyUser myUser, String title) {

        Blog blog = blogRepository.findBlogByTitle(title);
        if(blog==null){
            throw new ApiException("Blog not found.",404);
        }
        if(blog.getMyUser().getId() != myUser.getId()){
            throw new ApiException("You don't own this resource.",401);
        }

        return blog;

    }
}
