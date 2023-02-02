package com.example.project4.Service;

import com.example.project4.Exception.ApiException;
import com.example.project4.Model.Bootcamp;
import com.example.project4.Model.Student;
import com.example.project4.Repository.BootcampStudentRepository;
import com.example.project4.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final BootcampStudentService bootcampStudentService;
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository,
                          BootcampStudentService bootcampStudentService){
        this.studentRepository = studentRepository;
        this.bootcampStudentService = bootcampStudentService;
    }
    
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student oldStudent = studentRepository.findById(id).orElse(null);

        if(oldStudent == null)
            throw new ApiException("student with id: "+id+" was not found", 404);

        student.setId(id);
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findById(id).orElse(null);

        if (student == null){
            throw new ApiException("student with id: "+id+" was not found", 404);
        }
        bootcampStudentService.deleteByStudentId(id);
        studentRepository.delete(student);
    }

    public Bootcamp getBootcamp(Integer studentId){
        return bootcampStudentService.findBootcampOfStudent(studentId);
    }

    public List<Student> getAllStudentAbove(Integer age){
        return studentRepository.findStudentByAge(age);
    }

    public List<Student> getAllStudentWith(String major){
        return studentRepository.findStudentByMajor(major);
    }
}
