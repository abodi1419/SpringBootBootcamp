package com.example.directormicroservice.Service;

import com.example.directormicroservice.Exception.ApiException;
import com.example.directormicroservice.Model.Director;
import com.example.directormicroservice.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DirectorService {
    private final DirectorRepository directorRepository;


    public List<Director> getAll(){
        return directorRepository.findAll();
    }

    public void addDirector(Director director){
        directorRepository.save(director);
    }

    public Director findById(Integer id){
        Director director =directorRepository.findDirectorById(id);
        if(director==null){
            throw new ApiException("Director not found",404);
        }
        return director;
    }



    public void updateDirector(Integer id, Director director){
        Director oldDirector = directorRepository.findDirectorById(id);
        if(oldDirector ==null){
            throw new ApiException("Director not found!",404);
        }
        director.setId(id);
        directorRepository.save(director);
    }

    public void deleteDirector(Integer id){
        Director director = directorRepository.findDirectorById(id);
        if(director ==null){
            throw new ApiException("Director not found!",404);
        }
        directorRepository.delete(director);
    }


    public List<Director> getDirectorsByName(String name){
        List<Director> directors = directorRepository.findDirectorsByNameIsLike(name);
        if(directors.isEmpty()){
            throw new ApiException("No directors found with name provided! ",404);
        }
        return directors;
    }


}
