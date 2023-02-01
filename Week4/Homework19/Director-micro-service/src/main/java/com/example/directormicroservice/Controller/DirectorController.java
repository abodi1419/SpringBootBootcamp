package com.example.directormicroservice.Controller;

import com.example.directormicroservice.Model.Director;
import com.example.directormicroservice.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/director")
public class DirectorController {
    private final DirectorService directorService;

    @GetMapping("/get")
    public ResponseEntity getDirectors(){
        return ResponseEntity.status(200).body(directorService.getAll());
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getMovie(@PathVariable Integer id){
        Director director = directorService.findById(id);
        return ResponseEntity.status(200).body(director);
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@RequestBody @Valid Director director){
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director added");
    }



    @PutMapping("update/{id}")
    public ResponseEntity updateDirector(@PathVariable Integer id, @RequestBody @Valid Director director){
        directorService.updateDirector(id, director);
        return ResponseEntity.status(200).body("Updated successfully");

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id){
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

}
