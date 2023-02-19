package com.example.day3.Controller;

import com.example.day3.Pojo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    ArrayList<Task> tasks = new ArrayList<>();

    @PostMapping("/add")
    public String addTask(@RequestBody Task task){
        tasks.add(task);

        return "Task Added!";
    }

    @GetMapping("/get")
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index, @RequestBody Task task){
        tasks.set(index,task);

        return "Task updated";
    }


    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index){
        tasks.remove(index);
        return "Task Deleted";
    }

    @PutMapping("update/status/{index}")
    public String updateStatus(@PathVariable int index){
        if(tasks.get(index).getStatus().equals("not done")){
            tasks.get(index).setStatus("done");
        }
        else
            tasks.get(index).setStatus("not done");

        return "status Updated";
    }


    @PostMapping("get/task")
    public String getTask(@RequestParam String title){
        for (Task task:tasks) {
            if(task.getTitle().equals(title)){
                return task.toString();
            }
        }

        return "Title Wasn't Found";
    }



}
