package com.example.directormicroservice.Repository;

import com.example.directormicroservice.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

//    Movie findMovieByUsername(String username);
    Director findDirectorById(Integer id);
//    Movie findUserByEmail(String email);

//    @Query("select u.username from Movie u where u.id=?1")
//    String findUserName(Integer id);



    List<Director> findDirectorsByNameIsLike(String name);



}