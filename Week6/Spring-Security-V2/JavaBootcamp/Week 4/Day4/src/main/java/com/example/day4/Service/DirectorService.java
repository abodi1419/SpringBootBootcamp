package com.example.day4.Service;

import com.example.day4.Exception.ApiException;
import com.example.day4.Model.Director;
import com.example.day4.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;


    public List<Director> getDirectors(){
        return directorRepository.findAll();
    }

    public void addDirector(Director director){
        directorRepository.save(director);
    }

    public void updateDirector(Integer id, Director director){
        Director oldDirector = directorRepository.findById(id).orElse(null);

        if(oldDirector == null)
            throw new ApiException("ID not found");


        directorRepository.save(oldDirector);
    }

    public void deleteDirector(Integer id){
        Director director = directorRepository.findById(id).orElse(null);

        if (director == null){
            throw new ApiException("ID not found");
        }

        directorRepository.delete(director);
    }

    public String getDirectorName(Integer id){
        Director director = directorRepository.findById(id).orElse(null);

        if (director == null){
            throw new ApiException("Director ID was not found");
        }

        return director.getName();
    }

    public Integer getDirectorID(String name){
        Director director = directorRepository.findDirectorByName(name);

        if (director == null){
            throw new ApiException("Director name was not found");
        }

        return director.getId();
    }

}
