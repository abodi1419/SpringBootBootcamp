package com.example.project5.Repository;



import com.example.project5.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findLocationById(Integer id);
}