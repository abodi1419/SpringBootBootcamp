package com.example.project5.Service;



import com.example.project5.DTO.BookDTO;
import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Store;
import com.example.project5.Repository.BookRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final StoreService storeService;
    private final StoreRepository storeRepository;


    public Book findById(Integer id){
        Book book = bookRepository.findBookById(id);
        if(book ==null){
            throw new ApiException("Book not found!", 404);
        }
        return book;
    }
    public void addBook(BookDTO bookDTO){
        Store store = storeRepository.findStoreById(bookDTO.getStore_id());
        Book book = new Book(bookDTO.getName(), bookDTO.getBookCount(), bookDTO.getGenre() , store);
        bookRepository.save(book);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void attach(Integer book_id, Integer store_id){
        Book book = findById(book_id);
        Store store = storeService.findById(store_id);
        book.setStore(store);
        bookRepository.save(book);
    }

    public void detach(Integer book_id){
        Book book = findById(book_id);
        book.setStore(null);
        bookRepository.save(book);
    }
    public String getStoreName(Integer book_id){
        Book book = findById(book_id);
        Store store = book.getStore();
        if(store ==null){
            return "null";
        }
        return store.getName();

    }

    public void deleteBook(Integer book_id){
        Book book = findById(book_id);
        bookRepository.delete(book);

    }



//    public Director findById(Integer id){
//        Director director =directorRepository.findDirectorById(id);
//        if(director==null){
//            throw new ApiException("Director not found",404);
//        }
//        return director;
//    }
//
//
//
    public void updateBook(Integer id, BookDTO bookDTO){
        Book book = bookRepository.findBookById(id);
        if(book ==null){
            throw new ApiException("Book not found!",404);
        }
        if(bookDTO.getStore_id()>0){
            Store store = storeService.findById(bookDTO.getStore_id());
            book.setStore(store);
        }
        book.setName(bookDTO.getName());
        book.setBookCount(bookDTO.getBookCount());
        book.setGenre(bookDTO.getGenre());
        bookRepository.save(book);
    }

    public Integer getStock(Integer bookId){
        Book book = findById(bookId);
        return book.getBookCount();
    }

    public Book getBookByName(String bookName){
        Book book = bookRepository.findBookByName(bookName);
        return book;
    }

    public List<Book> getBooksByGenre(String genre){
        List<Book> books = bookRepository.findBooksByGenre(genre);
        return books;
    }

//    public void deleteAddress(Integer id){
//        Location address = addressRepository.findAddressById(id);
//        if(address ==null){
//            throw new ApiException("Location not found!",404);
//        }
//        addressRepository.delete(address);
//    }
//
//
//
//    public List<Director> getDirectorsByName(String name){
//        List<Director> directors = directorRepository.findDirectorsByNameIsLike(name);
//        if(directors.isEmpty()){
//            throw new ApiException("No directors found with name provided! ",404);
//        }
//        return directors;
//    }


}
