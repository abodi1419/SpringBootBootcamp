package com.example.homework13.Conntrollers;

import com.example.homework13.Pogo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/tasks")
public class MainController {
    ArrayList<Task> tasks = new ArrayList<>();
    int id =1;

    @GetMapping("/get")
    public ArrayList<Task> get(){
        return tasks;
    }

    @PostMapping("/add")
    public String add(@RequestBody Task task){
        task.setId(id+"");
        id++;
        task.setStatus("Not done");
        tasks.add(task);
        return task.getTitle();
    }

    @PutMapping("/update/{id}")
    public String updateTask(@PathVariable String id, @RequestBody Task task){
        for (Task myTask : tasks) {
            if(myTask.getId().equals(id)){
                myTask.setTitle(task.getTitle());
                myTask.setDescription(task.getDescription());
                myTask.setStatus(task.getStatus());
            }
        }
        return "Updated!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable String id){
        for (int i=0; i<tasks.size();i++){
            if(tasks.get(i).getId().equals(id)){
                tasks.remove(i);
                return "Deleted!";
            }
        }
        return "Not found so not deleted!";
    }

    @PutMapping("/update/status/{id}")
    public String updateStatus(@PathVariable String id){
        for (int i=0; i<tasks.size();i++){
            if(tasks.get(i).getId().equals(id)){
                if(tasks.get(i).getStatus().equals("Not done")){
                    tasks.get(i).setStatus("Done");
                    return "Task status updated to done";
                }else {
                    tasks.get(i).setStatus("Not done");
                    return "Task status updated to not done";

                }
            }
        }
        return "Task not found so status not updated!";

    }

    @PostMapping("get/by/title")
    public String getByTitle(@RequestParam String title){
        for (int i=0; i<tasks.size();i++){
            if(tasks.get(i).getTitle().equals(title)){
               return tasks.get(i).toString();
            }
        }
        return "Not found!";
    }


}
