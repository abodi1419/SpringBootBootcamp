package com.example.day2.Service;

import com.example.day2.Exception.ApiException;
import com.example.day2.Model.Blog;
import com.example.day2.Model.User;
import com.example.day2.Repository.BlogRepository;
import com.example.day2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public List<Blog> getBlogs(UUID id) {
        return userRepository.findUserById(id).getBlogs();
    }

    public void addBlog(User user,Blog blog) {
        blog.setUser(user);
        blogRepository.save(blog);
    }

    public void removeBlog(User user, UUID blogId) {
        Blog blog=blogRepository.findBlogById(blogId);
        if(!(blog.getUser().getId().equals(user.getId()))){
            throw new ApiException("user not allowed to delete this id");
        }
        blogRepository.delete(blog);
    }

    public void updateBlog(User user, UUID blogId, Blog blog){
        Blog oldBlog = blogRepository.findBlogById(blogId);

        if(!(oldBlog.getUser().getId().equals(user.getId()))){
            throw new ApiException("user not allowed to update this id");
        }

        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());
        blogRepository.save(oldBlog);
    }

    public Blog getBlogById(User user, UUID id){
        Blog blog = blogRepository.findBlogById(id);
        if(blog == null || !(blog.getUser().getId().equals(user.getId())))
            throw new ApiException("user not allowed to access the blog");
        return blog;
    }

    public Blog getBlogByTitle(User user, String title){
        Blog blog = blogRepository.findBlogByTitle(title);
        if(blog == null || !(blog.getUser().getId().equals(user.getId())))
            throw new ApiException("user not allowed to access the blog");
        return blog;
    }

}
