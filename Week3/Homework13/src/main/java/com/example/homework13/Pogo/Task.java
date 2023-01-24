package com.example.homework13.Pogo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Task {
    private String id;
    private String title;
    private String description;
    private String status;

    public Task(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }
}
