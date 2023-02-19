package com.example.project4.Repository;

import com.example.project4.Model.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {

//    Movie findMovieByUsername(String username);
    Bootcamp findBootcampById(Integer id);

    @Query("select b from Bootcamp b where b.startDate<?1 and b.endDate>?1")
    List<Bootcamp> findBootcampsByStart_dateGreaterThanEqualAndEnd_dateLessThan(Date date);
//    Movie findUserByEmail(String email);

//    @Query("select u.username from Movie u where u.id=?1")
//    String findUserName(Integer id);


    @Query(value = "select b from Bootcamp b where b.name like %?1%")
    List<Bootcamp> findBootcampByNameIsLike(String name);





}