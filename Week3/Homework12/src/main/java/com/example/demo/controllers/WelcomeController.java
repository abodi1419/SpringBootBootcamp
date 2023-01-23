package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// You can find practice 1 solution in project root folder under week3/homework12/practice 1 spring
@RestController
public class WelcomeController {
    @GetMapping("name")
    public String getName(){
        return "My name is abdullah";
    }

    @GetMapping("age")
    public String getAge(){
        return "My age is 24";
    }

    @GetMapping("check/status")
    public String checkStatus(){
        return "Everythis is ok!";
    }

    @GetMapping("health")
    public String getHealth(){
        return "Server health is up and running";
    }


}
