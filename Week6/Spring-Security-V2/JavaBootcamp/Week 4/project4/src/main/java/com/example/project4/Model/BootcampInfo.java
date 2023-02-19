package com.example.project4.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class BootcampInfo {
    private Bootcamp bootcamp;
    private List<Instructor> instructors;
    private List<Student> students;
}
