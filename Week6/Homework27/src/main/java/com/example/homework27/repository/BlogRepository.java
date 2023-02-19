package com.example.homework27.repository;

import com.example.homework27.model.Blog;
import com.example.homework27.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value = "select b from Blog b where b.myUser.id=?1")
    List<Blog> findBlogsByMyUser(Integer id);

    Blog findBlogByTitle(String title);


}
