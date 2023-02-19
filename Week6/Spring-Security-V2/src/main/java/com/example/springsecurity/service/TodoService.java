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


    public List<Todo> getTodos(Integer user_id) {
        MyUser user = authRepository.findMyUserById(user_id);
        return todoRepository.findAllByMyUser(user);
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public void addTodo(MyUser myUser,Todo todo) {
        MyUser user = authRepository.findMyUserById(myUser.getId());
        if (myUser == null){
            throw new ApiException("User not found",404);
        }
        todo.setMyUser(myUser);
        todoRepository.save(todo);
    }

    public void removeTodo(Integer userId, Integer todoId) {
        Todo todo=todoRepository.findTodoById(todoId);

        if(todo==null){
            throw new ApiException("Todo not found!",404);

        }
        if(todo.getMyUser().getId()!=userId){
            throw new ApiException("Unauthorized access!",401);
        }

        todoRepository.deleteById(todoId);
    }

    public void updateTodo(Integer userId,Integer todoId, Todo todo) {
        Todo oldTodo = todoRepository.findTodoById(todoId);
        if(oldTodo==null){
            throw new ApiException("Todo not found!",404);

        }
        if(oldTodo.getMyUser().getId()!=userId){
            throw new ApiException("Unauthorized access!",401);
        }


        oldTodo.setMessage(todo.getMessage());
        todoRepository.save(oldTodo);
    }
}
