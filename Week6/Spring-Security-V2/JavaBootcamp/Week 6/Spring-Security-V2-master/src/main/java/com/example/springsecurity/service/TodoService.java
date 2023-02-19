package com.example.springsecurity.service;


import com.example.springsecurity.Exception.ApiException;
import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import com.example.springsecurity.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

   private final TodoRepository todoRepository;
   private final AuthRepository authRepository;

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }
    public List<Todo> getTodos(Integer id) {
        MyUser myUser = authRepository.findMyUserById(id);
        return todoRepository.findAllByMyUser(myUser);
    }

    public void addTodo(Integer id,Todo todo) {
        MyUser myUser = authRepository.findMyUserById(id);
        if (myUser == null){
            throw new ApiException("ID not found");
        }
        todo.setMyUser(myUser);
        todoRepository.save(todo);
    }

    public void removeTodo(Integer userId, Integer todoId) {
        Todo todo=todoRepository.findTodoById(todoId);
        if (todo == null)
            throw new ApiException("ID not found");
        if(todo.getMyUser().getId()!=userId){
            throw new ApiException("user not allowed to delete this id");
        }
        todoRepository.deleteById(todoId);
    }

    public void updateTodo(Integer userId, Integer todoId, Todo todo){
        Todo oldTodo = todoRepository.findTodoById(todoId);

        if (oldTodo == null)
            throw new ApiException("Id not found");
        if(oldTodo.getMyUser().getId() != userId){
            throw new ApiException("user not allowed to update this id");
        }

        oldTodo.setMessage(todo.getMessage());
        todoRepository.save(oldTodo);
    }
}
