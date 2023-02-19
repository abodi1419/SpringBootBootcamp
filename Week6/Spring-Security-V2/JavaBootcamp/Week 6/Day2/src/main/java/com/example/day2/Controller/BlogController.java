package com.example.day2.Controller;

import com.example.day2.Model.Blog;
import com.example.day2.Model.User;
import com.example.day2.Response;
import com.example.day2.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;


    @GetMapping()
    public ResponseEntity<List<Blog>> getBlogs(@AuthenticationPrincipal User user){
        List<Blog> blogs = blogService.getBlogs(user.getId());
        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping()
    public ResponseEntity <Response> addBlogs(@AuthenticationPrincipal User user,@Valid @RequestBody Blog blog){
        blogService.addBlog(user,blog);
        return ResponseEntity.status(201).body(new Response("New Blog added !",201));
    }

    @DeleteMapping("/")
    public ResponseEntity <Response> deleteBlogs(@AuthenticationPrincipal User user, @RequestBody Blog blog){
        blogService.removeBlog(user, blog.getId());
        return ResponseEntity.status(200).body(new Response("Blog deleted !",200));
    }

    @PutMapping("/{blogId}")
    public ResponseEntity<Response> updateBlog(@AuthenticationPrincipal User user, @PathVariable UUID blogId,@Valid @RequestBody Blog blog){
        blogService.updateBlog(user, blogId, blog);
        return ResponseEntity.status(200).body(new Response("Blog updated !",200));
    }

    @GetMapping("/id")
    public ResponseEntity<Blog> getBlogById(@AuthenticationPrincipal User user, @RequestBody Blog blog){
        Blog blog1 = blogService.getBlogById(user, blog.getId());
        return ResponseEntity.status(200).body(blog1);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Blog> getBlogByTitle(@AuthenticationPrincipal User user, @PathVariable String title){
        Blog blog = blogService.getBlogByTitle(user, title);
        return ResponseEntity.status(200).body(blog);
    }


}
