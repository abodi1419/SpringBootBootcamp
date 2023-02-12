package com.example.project5.Controller;



import com.example.project5.DTO.LocationDTO;
import com.example.project5.DTO.BookDTO;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Service.LocationService;
import com.example.project5.Service.BookService;
import com.example.project5.Service.CustomerService;
import com.example.project5.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/store")
public class StoreController {
    private final StoreService storeService;
    private final LocationService locationService;
    private final BookService bookService;
    private final CustomerService customerService;

    @GetMapping("/get/stores")
    public ResponseEntity getStores(){
        return ResponseEntity.status(200).body(storeService.getStores());
    }

    @GetMapping("/get/books")
    public ResponseEntity getBooks(){
        return ResponseEntity.status(200).body(bookService.getBooks());
    }

    @GetMapping("/get/customers")
    public ResponseEntity getCustomers(){
        return ResponseEntity.status(200).body(customerService.getCustomers());
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getStore(@PathVariable Integer id){
        Store store = storeService.findById(id);
        return ResponseEntity.status(200).body(store);
    }


    @PostMapping("/add")
    public ResponseEntity addStore(@RequestBody @Valid Store store){
        storeService.addStore(store);
        return ResponseEntity.status(200).body("Store added");
    }

    @PostMapping("/add/location")
    public ResponseEntity addStoreLocation(@RequestBody @Valid LocationDTO locationDTO){
        locationService.addLocation(locationDTO);
        return ResponseEntity.status(200).body("Store location added");
    }

    @PostMapping("/add/book")
    public ResponseEntity addBook(@RequestBody @Valid BookDTO bookDTO){
        bookService.addBook(bookDTO);
        return ResponseEntity.status(200).body("Book added!");
    }

    @PostMapping("/add/customer")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer added!");
    }





    @PutMapping("update/{id}")
    public ResponseEntity updateStore(@PathVariable Integer id, @RequestBody @Valid Store store){
        storeService.updateStore(id, store);
        return ResponseEntity.status(200).body("Updated successfully");

    }

    @PutMapping("attach/{storeId}/book/{bookId}")
    public ResponseEntity attachBookToStore(@PathVariable Integer storeId, @PathVariable Integer bookId){
        bookService.attach(bookId, storeId);
        return ResponseEntity.status(200).body("Book attached successfully");

    }

    @PutMapping("detach/book/{bookId}")
    public ResponseEntity detachBook( @PathVariable Integer bookId){
        bookService.detach(bookId);
        return ResponseEntity.status(200).body("Book detached successfully");

    }

    @PutMapping("attach/customer/{customerId}/store/{storeId}")
    public ResponseEntity attachCustomerToStore(@PathVariable Integer customerId, @PathVariable Integer storeId){
        customerService.attach(customerId,storeId);
        return ResponseEntity.status(200).body("Customer attached successfully");

    }

    @PutMapping("/detach/customer/{customerId}/store/{storeId}")
    public ResponseEntity detachCustomerStore(@PathVariable Integer customerId,@PathVariable Integer storeId){
        customerService.detach(customerId,storeId);
        return ResponseEntity.status(200).body("Customer detached successfully");

    }


    @PutMapping("/update/location")
    public ResponseEntity updateLocation(@RequestBody @Valid LocationDTO locationDTO){
        locationService.updateLocation(locationDTO);
        return ResponseEntity.status(200).body("Updated successfully");

    }

    @PutMapping("/update/book/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id,@RequestBody @Valid BookDTO bookDTO){
        bookService.updateBook(id, bookDTO);
        return ResponseEntity.status(200).body("Updated successfully");

    }

    @PutMapping("/update/customer/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id,@RequestBody @Valid Customer customer){
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Updated successfully");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id){
        storeService.deleteStore(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

    @DeleteMapping("/delete/location/{id}")
    public ResponseEntity deleteLocation(@PathVariable Integer id){
        locationService.deleteLocation(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

    @DeleteMapping("/delete/book/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

    @DeleteMapping("/delete/customer/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

    @GetMapping("/get/book/stock/{id}")
    public ResponseEntity getBookStock(@PathVariable Integer id){
        return ResponseEntity.status(200).body(bookService.getStock(id));
    }

    @GetMapping("/get/book/name")
    public ResponseEntity getBookStock(@RequestBody BookDTO book){
        return ResponseEntity.status(200).body(bookService.getBookByName(book.getName()));
    }

    @GetMapping("/get/books/genre")
    public ResponseEntity getBooksByGenre(@RequestBody BookDTO book){
        return ResponseEntity.status(200).body(bookService.getBooksByGenre(book.getGenre()));
    }

    @GetMapping("/get/books/{id}")
    public ResponseEntity getBookOfStore(@PathVariable Integer id){
        return ResponseEntity.status(200).body(storeService.getBooks(id));
    }

    @GetMapping("/get/customers/{id}")
    public ResponseEntity getCustomersOfStore(@PathVariable Integer id){
        return ResponseEntity.status(200).body(storeService.getCustomers(id));
    }




}
