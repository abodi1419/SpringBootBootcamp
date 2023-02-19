package com.example.day2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/name")
    public String getName() {
        return "My name is Abdulaziz Bashiri";
    }

    @GetMapping("/age")
    public String getAge() {
        return "My age is 22";
    }

    @GetMapping("/check/status")
    public String getStatus() {
        return "Everything OK";
    }


    @GetMapping("/health")
    public String getHealth() {
        return "Server health is up and running";
    }


}
