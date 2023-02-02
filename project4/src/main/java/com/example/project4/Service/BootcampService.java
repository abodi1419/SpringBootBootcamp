package com.example.project4.Service;

import com.example.project4.Exception.ApiException;
import com.example.project4.Model.Bootcamp;
import com.example.project4.Model.BootcampInfo;
import com.example.project4.Model.Instructor;
import com.example.project4.Model.Student;
import com.example.project4.Repository.BootcampRepository;
import com.example.project4.Repository.BootcampStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BootcampService {
    private final BootcampRepository bootcampRepository;
    private final BootcampInstructorService bootcampInstructorService;
    private final BootcampStudentService bootcampStudentService;


    public List<Bootcamp> getAll(){
        return bootcampRepository.findAll();
    }

    public void addBootcamp(Bootcamp director){
        bootcampRepository.save(director);
    }

    public Bootcamp findById(Integer id){
        Bootcamp bootcamp =bootcampRepository.findBootcampById(id);
        if(bootcamp==null){
            throw new ApiException("Bootcamp not found",404);
        }
        return bootcamp;
    }

    public List<Bootcamp> getByName(String name){
        List<Bootcamp> bootcamps = bootcampRepository.findBootcampByNameIsLike(name);
        if(bootcamps.isEmpty()){
            throw new ApiException("No bootcamps found like name provided!",404);
        }
        return bootcamps;
    }


    public void updateBootcamp(Integer id, Bootcamp bootcamp){
        Bootcamp oldBootcamp = bootcampRepository.findBootcampById(id);
        if(oldBootcamp ==null){
            throw new ApiException("Bootcamp not found!",404);
        }
        bootcamp.setId(id);
        bootcampRepository.save(bootcamp);
    }

    public void deleteBootcamp(Integer id){
        Bootcamp bootcamp = bootcampRepository.findBootcampById(id);
        if(bootcamp ==null){
            throw new ApiException("Bootcamp not found!",404);
        }
        bootcampInstructorService.deleteByBootcampId(id);
        bootcampStudentService.deleteByBootcampId(id);
        bootcampRepository.delete(bootcamp);
    }


    public List<Bootcamp> getBootcampByName(String name){
        List<Bootcamp> bootcamps = bootcampRepository.findBootcampByNameIsLike(name);
        if(bootcamps.isEmpty()){
            throw new ApiException("No directors found with name provided! ",404);
        }
        return bootcamps;
    }

    public List<Instructor> getInstructors(Integer bootcampId){
        return bootcampInstructorService.findInstructorsOfBootcamp(bootcampId);
    }

    public List<Student> getStudents(Integer bootcampId){
        return bootcampStudentService.findStudentsOfBootcamp(bootcampId);
    }

    public BootcampInfo getInfo(Integer bootcampId){
        Bootcamp bootcamp = findById(bootcampId);
        List<Instructor> instructors = getInstructors(bootcampId);
        List<Student> students = getStudents(bootcampId);
        return new BootcampInfo(bootcamp,instructors,students);
    }


}
