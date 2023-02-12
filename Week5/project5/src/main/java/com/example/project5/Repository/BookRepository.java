package com.example.project5.Repository;



import com.example.project5.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findBookById(Integer id);

    List<Book> findBooksByGenre(String genre);

    Book findBookByName(String name);

}