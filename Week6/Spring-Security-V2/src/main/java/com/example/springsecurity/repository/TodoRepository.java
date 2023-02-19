package com.example.springsecurity.repository;

import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {

    Todo findTodoById(Integer id);
    List<Todo> findAllByMyUserId(Integer userId);


    List<Todo> findAllByMyUser(MyUser myUser);
}
