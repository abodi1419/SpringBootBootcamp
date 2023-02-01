package com.example.project4.Service;

import com.example.project4.Exception.ApiException;
import com.example.project4.Model.Bootcamp;
import com.example.project4.Model.Instructor;
import com.example.project4.Repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final BootcampInstructorService bootcampInstructorService;

    public List<Instructor> getInstructors(){
        return instructorRepository.findAll();
    }

    public void addInstructor(Instructor instructor){
        instructorRepository.save(instructor);
    }

    public void updateInstructor(Integer id, Instructor instructor){
        Instructor oldInstructor = instructorRepository.findById(id).orElse(null);

        if(oldInstructor == null)
            throw new ApiException("ID not found", 404);

        instructor.setId(id);
        instructorRepository.save(instructor);
    }

    public void deleteInstructor(Integer id){
        Instructor instructor = instructorRepository.findById(id).orElse(null);

        if (instructor == null){
            throw new ApiException("ID not found", 404);
        }
        bootcampInstructorService.deleteByInstructorId(id);
        instructorRepository.delete(instructor);
    }

    public List<Bootcamp> getBootcamps(Integer instructorId){
        return bootcampInstructorService.findBootcampsOfInstructor(instructorId);
    }
}
