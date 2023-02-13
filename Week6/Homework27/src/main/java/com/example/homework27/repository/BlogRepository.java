package com.example.homework27.repository;

import com.example.homework27.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    List<Blog> findAllByMyUserId(Integer userId);

    Blog findBlogByTitle(String title);


}
