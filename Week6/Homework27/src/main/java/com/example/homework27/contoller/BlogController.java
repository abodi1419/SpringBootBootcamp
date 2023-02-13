package com.example.homework27.contoller;

import com.example.homework27.ApiResponse;
import com.example.homework27.model.Blog;
import com.example.homework27.model.MyUser;
import com.example.homework27.service.BlogService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {

    private BlogService blogService;


    @GetMapping()
    public ResponseEntity <List<Blog>> getBlogs(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(blogService.getBlogs(myUser));
    }

    @GetMapping("{blogId}")
    public ResponseEntity <Blog> getBlogById(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer blogId){
        return ResponseEntity.status(200).body(blogService.getBlogById(myUser,blogId));
    }
    @GetMapping("/title")
    public ResponseEntity <Blog> getBlogById(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog){
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(myUser,blog.getTitle()));
    }

    @PostMapping()
    public ResponseEntity <ApiResponse> addBlogs(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog){
        blogService.addBlog(myUser,blog);
        return ResponseEntity.status(201).body(new ApiResponse("New Blog added !",201));
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity <ApiResponse> addBlogs(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer blogId){
        blogService.removeBlog(myUser.getId(),blogId);
        return ResponseEntity.status(200).body(new ApiResponse("Blog deleted !",200));
    }

    @PutMapping("/{blogId}")
    public ResponseEntity<ApiResponse> updateBlog(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer blogId, @RequestBody @Valid Blog blog){
        blogService.updateBlog(myUser.getId(),blogId,blog);
        return ResponseEntity.status(200).body(new ApiResponse("Blog updated !",200));

    }


}
