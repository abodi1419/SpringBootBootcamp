package com.example.project5.Service;

import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Store;
import com.example.project5.Repository.BookRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final StoreRepository storeRepository;

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Integer id, Book book){
        Book oldBook = bookRepository.findBookById(id);

        if(oldBook == null)
            throw new ApiException("ID not found");

        oldBook.setName(book.getName());
        oldBook.setBook_count(book.getBook_count());
        oldBook.setGenre(book.getGenre());
        bookRepository.save(oldBook);
    }

    public void deleteBook(Integer id){
        Book book = bookRepository.findBookById(id);

        if (book == null){
            throw new ApiException("ID not found");
        }

        bookRepository.delete(book);
    }

    public void assignBookToStore(Integer book_id, Integer store_id){
        Book book = bookRepository.findBookById(book_id);
        Store store = storeRepository.findStoreById(store_id);
        if (book == null || store == null)
            throw new ApiException("ID not found");
        book.setStore(store);
        bookRepository.save(book);
    }


    public int getBooksAvailable(Integer id){
        Book book = bookRepository.findBookById(id);
        if (book == null)
            throw new ApiException("ID not found");
        return book.getBook_count();
    }

    public Book getBookByName(String name){
        Book book = bookRepository.findBookByName(name);
        if (book == null)
            throw new ApiException("ID not found");
        return book;
    }

    public List<Book> getBooksByGenre(String genre){
        return bookRepository.findBooksByGenre(genre);
    }
}
