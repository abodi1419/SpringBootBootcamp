package com.example.springsecurity;

import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import com.example.springsecurity.repository.TodoRepository;
import com.example.springsecurity.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @InjectMocks
    TodoService todoService;
    @Mock
    TodoRepository todoRepository;
    @Mock
    AuthRepository authRepository;

    MyUser user;
    Todo todo1,todo2,todo3;
    List<Todo> todos ;
    @BeforeEach
    void setUp() {
        user = new MyUser(null,"Abdullah","123","ADMIN",null);
        todo1 = new Todo(1,"todo1",user);
        todo2 = new Todo(2,"todo2",user);
        todo3 = new Todo(3,"todo3",null);

        todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);
    }

    @Test
    public void getAllTodosTest(){
        when(todoRepository.findAll()).thenReturn(todos);
        List<Todo> todoList = todoService.getAllTodos();
        Assertions.assertEquals(3,todoList.size());
        verify(todoRepository, times(1)).findAll();
    }

    @Test
    public void getTodosByIdTest(){
        when(authRepository.findMyUserById(user.getId())).thenReturn(user);
        when(todoRepository.findAllByMyUser(user)).thenReturn(todos);


        List<Todo> todoList = todoService.getTodos(user.getId());
        Assertions.assertEquals(todoList,todos);
        verify(authRepository,times(1)).findMyUserById(user.getId());
        verify(todoRepository,times(1)).findAllByMyUser(user);
    }

    @Test
    public void addTodoTest(){
        when(authRepository.findMyUserById(user.getId())).thenReturn(user);
        todoService.addTodo(user.getId(), todo3);
        verify(authRepository,times(1)).findMyUserById(user.getId());
        verify(todoRepository,times(1)).save(todo3);
    }

    @Test
    public void updateTodoTest(){
        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);

        todoService.updateTodo(user.getId(), todo1.getId(),todo2);

        verify(todoRepository,times(1)).findTodoById(todo1.getId());
        verify(todoRepository,times(1)).save(todo1);
    }

    @Test
    public void deleteTodoTest(){
        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);

        todoService.removeTodo(user.getId(), todo1.getId());

        verify(todoRepository,times(1)).findTodoById(todo1.getId());
        verify(todoRepository,times(1)).deleteById(todo1.getId());
    }
}
