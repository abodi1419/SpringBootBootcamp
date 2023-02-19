package com.example.day3.Service;

import com.example.day3.Exception.ApiException;
import com.example.day3.Model.Teacher;
import com.example.day3.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher){
        Teacher oldTeacher = teacherRepository.findById(id).orElse(null);

        if(oldTeacher == null)
            throw new ApiException("ID not found");

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findById(id).orElse(null);

        if (teacher == null){
            throw new ApiException("ID not found");
        }

        teacherRepository.delete(teacher);
    }

    public Teacher getTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("ID not found");
        }
        return teacher;
    }

}
