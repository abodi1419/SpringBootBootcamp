package com.example.project5.Repository;

import com.example.project5.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    Book findBookByName(String name);
    List<Book> findBooksByGenre(String genre);
}
