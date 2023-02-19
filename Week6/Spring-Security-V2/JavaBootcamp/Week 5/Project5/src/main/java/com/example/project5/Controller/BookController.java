package com.example.project5.Controller;

import com.example.project5.Model.Book;
import com.example.project5.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity getBooks(){
        return ResponseEntity.status(200).body(bookService.getBooks());
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Book book){
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body("Book Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book was deleted");
    }

    @PutMapping("/assign/{book_id}/store/{store_id}")
    public ResponseEntity assignBookToStore(@PathVariable Integer book_id, @PathVariable Integer store_id){
        bookService.assignBookToStore(book_id,store_id);
        return ResponseEntity.status(200).body("Book was assigned");
    }

    @GetMapping("/available/{id}")
    public ResponseEntity getBooksAvailable(@PathVariable Integer id){
        int available = bookService.getBooksAvailable(id);
        return ResponseEntity.status(200).body("There are " + available + " available");
    }

    @GetMapping("/info/{name}")
    public ResponseEntity getBookByName(@PathVariable String name){
        Book book = bookService.getBookByName(name);
        return ResponseEntity.status(200).body(book);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity getBooksByGenre(@PathVariable String genre){
        List<Book> books = bookService.getBooksByGenre(genre);
        return ResponseEntity.status(200).body(books);
    }

}
