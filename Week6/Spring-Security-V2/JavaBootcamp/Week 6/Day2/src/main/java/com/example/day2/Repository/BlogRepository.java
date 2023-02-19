package com.example.day2.Repository;

import com.example.day2.Model.Blog;
import com.example.day2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BlogRepository extends JpaRepository<Blog, UUID> {
    Blog findBlogById(UUID id);
    Blog findBlogByTitle(String title);

    List<Blog> findAllByUser(User user);
}
