package com.example.day4.Repository;

import com.example.day4.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
    Director findDirectorByName(String name);
}
