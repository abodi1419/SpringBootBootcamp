package com.example.homework22.Service;



import com.example.homework22.Exception.ApiException;
import com.example.homework22.Model.Teacher;
import com.example.homework22.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;


    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public Teacher findById(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher ==null){
            throw new ApiException("Teacher not found",404);
        }
        return teacher;
    }



    public void updateTeacher(Integer id, Teacher teacher){
        Teacher oldTeacher = findById(id);
        teacher.setId(id);
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = findById(id);
        teacherRepository.delete(teacher);
    }


    public List<Teacher> getTeachersByName(String name){
        List<Teacher> teachers = teacherRepository.findTeachersByName(name);
        if(teachers.isEmpty()){
            throw new ApiException("No teachers found with name provided! ",404);
        }
        return teachers;
    }


}
