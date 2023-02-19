package com.example.project4.Service;

import com.example.project4.Exception.ApiException;
import com.example.project4.Model.*;
import com.example.project4.Repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BootcampStudentService {

    private final BootcampRepository bootcampRepository;
    private final StudentRepository studentRepository;
    private final BootcampStudentRepository bootcampStudentRepository;

    public BootcampStudentService(BootcampStudentRepository bootcampStudentRepository,
                                  StudentRepository studentRepository,
                                  BootcampRepository bootcampRepository){
        this.bootcampStudentRepository = bootcampStudentRepository;
        this.studentRepository = studentRepository;
        this.bootcampRepository = bootcampRepository;
    }

    public void addBootcampStudent(Integer bootcampId, Integer studentId) {
        Bootcamp bootcamp = bootcampRepository.findBootcampById(bootcampId);
        if (bootcamp == null)
            throw new ApiException("Bootcamp id was not found",404);

        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null)
            throw new ApiException("student id was not found",404);

        BootcampStudent studentBootcamp = bootcampStudentRepository.findBootcampStudentByStudentId(studentId);
        if (studentBootcamp != null)
            throw new ApiException("student with id: "+studentId+" is already registered in a bootcamp.",402);

        List<BootcampStudent> bootcampStudents = bootcampStudentRepository.findBootcampStudentsByBootcampId(bootcampId);
        if(bootcamp.getCapacity()<= bootcampStudents.size()){
            throw new ApiException("Bootcamp is already full!", 400);
        }


        bootcampStudentRepository.save(new BootcampStudent(bootcampId,studentId));
    }

    public void deleteStudentFromBootcamp(Integer bootcampId, Integer studentId){
        BootcampStudent bootcampStudent = bootcampStudentRepository.findBootcampStudentByBootcampIdAndStudentId(bootcampId,studentId);
        if (bootcampStudent == null)
            throw new ApiException("The student is not assigned the bootcamp!",404);
        bootcampStudentRepository.delete(bootcampStudent);
    }

    public void deleteByBootcampId(Integer bootcampId){
        List<BootcampStudent> bootcampStudents = bootcampStudentRepository.findBootcampStudentsByBootcampId(bootcampId);
        bootcampStudentRepository.deleteAll(bootcampStudents);
    }

    public void deleteByStudentId(Integer studentId){
        BootcampStudent bootcampStudent = bootcampStudentRepository.findBootcampStudentByStudentId(studentId);
        if(bootcampStudent == null)
            return;
        bootcampStudentRepository.delete(bootcampStudent);
    }


    public List<Student> findStudentsOfBootcamp(Integer bootcampId, boolean returnNull){
        List<BootcampStudent> bootcampStudents = bootcampStudentRepository.findBootcampStudentsByBootcampId(bootcampId);
        if(!returnNull) {
            if (bootcampStudents.isEmpty()) {
                throw new ApiException("No students assigned to this bootcamp!", 404);
            }
        }
        List<Integer> ids = new ArrayList<>();
        for (BootcampStudent b: bootcampStudents){
            ids.add(b.getStudentId());
        }
        return studentRepository.findAllById(ids);
    }

    public Bootcamp findBootcampOfStudent(Integer studentId){
        BootcampStudent bootcampStudent = bootcampStudentRepository.findBootcampStudentByStudentId(studentId);

        if(studentRepository.findStudentById(studentId)==null){
            throw new ApiException("Student not found!",404);
        }
        if(bootcampStudent == null){
            throw new ApiException("You are not assigned to any bootcamp!",404);
        }
        Bootcamp bootcamp = bootcampRepository.findById(bootcampStudent.getBootcampId()).orElse(null);

        if(bootcamp == null){
            throw new ApiException("You are not assigned to any bootcamp!",404);
        }
        return bootcamp;
    }

    // Student has only one bootcamp

//    public void deleteByStudentId(Integer studentId){
//        List<BootcampStudent> bootcampStudents = bootcampStudentRepository.findBootcampStudentsByStudentId(studentId);
//        bootcampStudentRepository.deleteAll(bootcampStudents);
//    }

//    public List<Bootcamp> findBootcampsOfStudent(Integer studentId){
//        List<BootcampStudent> bootcampStudents = bootcampStudentRepository.findBootcampStudentsByStudentId(studentId);
//        if(bootcampStudents.isEmpty()){
//            throw new ApiException("You are not assigned to any bootcamp!",404);
//        }
//        List<Integer> ids = new ArrayList<>();
//        for (BootcampStudent b: bootcampStudents){
//            ids.add(b.getBootcampId());
//        }
//        return bootcampRepository.findAllById(ids);
//    }
}
