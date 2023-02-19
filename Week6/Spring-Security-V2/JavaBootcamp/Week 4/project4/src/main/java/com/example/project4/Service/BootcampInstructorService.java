package com.example.project4.Service;

import com.example.project4.Exception.ApiException;
import com.example.project4.Model.Bootcamp;
import com.example.project4.Model.BootcampInstructor;
import com.example.project4.Model.Instructor;
import com.example.project4.Repository.BootcampInstructorRepository;
import com.example.project4.Repository.BootcampRepository;
import com.example.project4.Repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BootcampInstructorService {

    private final BootcampInstructorRepository bootcampInstructorRepository;
    private final BootcampRepository bootcampRepository;
    private final InstructorRepository instructorRepository;

    public void addBootcampInstructor(Integer bootcampId, Integer instructorId) {
        Bootcamp bootcamp = bootcampRepository.findBootcampById(bootcampId);
        if (bootcamp == null)
            throw new ApiException("Bootcamp id was not found",404);
        Instructor instructor = instructorRepository.findInstructorById(instructorId);
        if (instructor == null)
            throw new ApiException("instructor id was not found",404);

        bootcampInstructorRepository.save(new BootcampInstructor(bootcampId,instructorId));
    }

    public void deleteInstructorFromBootcamp(Integer bootcampId, Integer instructorId){
        BootcampInstructor bootcampInstructor = bootcampInstructorRepository.findBootcampInstructorByBootcampIdAndInstructorId(bootcampId,instructorId);
        if (bootcampInstructor == null)
            throw new ApiException("The instructor is not assigned the bootcamp!!!",404);
        bootcampInstructorRepository.delete(bootcampInstructor);
    }

    public void deleteByBootcampId(Integer bootcampId){
        List<BootcampInstructor> bootcampInstructors = bootcampInstructorRepository.findBootcampInstructorsByBootcampId(bootcampId);
        bootcampInstructorRepository.deleteAll(bootcampInstructors);
    }

    public void deleteByInstructorId(Integer instructorId){
        List<BootcampInstructor> bootcampInstructors = bootcampInstructorRepository.findBootcampInstructorsByInstructorId(instructorId);
        bootcampInstructorRepository.deleteAll(bootcampInstructors);
    }

    public List<Instructor> findInstructorsOfBootcamp(Integer bootcampId, boolean returnNull){
        List<BootcampInstructor> bootcampInstructors = bootcampInstructorRepository.findBootcampInstructorsByBootcampId(bootcampId);
        if(!returnNull) {
            if (bootcampInstructors.isEmpty()) {
                throw new ApiException("No instructors assigned to this bootcamp!", 404);
            }
        }
        List<Integer> ids = new ArrayList<>();
        for (BootcampInstructor b: bootcampInstructors){
            ids.add(b.getInstructorId());
        }
        return instructorRepository.findAllById(ids);
    }

    public List<Bootcamp> findBootcampsOfInstructor(Integer instructorId){
        List<BootcampInstructor> bootcampInstructors = bootcampInstructorRepository.findBootcampInstructorsByInstructorId(instructorId);
        if(bootcampInstructors.isEmpty()){
            throw new ApiException("You are not assigned to any bootcamp!",404);
        }
        List<Integer> ids = new ArrayList<>();
        for (BootcampInstructor b: bootcampInstructors){
            ids.add(b.getBootcampId());
        }
        return bootcampRepository.findAllById(ids);
    }


}
