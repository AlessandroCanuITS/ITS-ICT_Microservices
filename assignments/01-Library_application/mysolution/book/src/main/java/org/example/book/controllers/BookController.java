package org.example.book.controllers;

import org.example.book.exceptions.BookNotFoundException;
import org.example.book.models.Book;
import org.example.book.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/v2/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //CREATE A BOOK
    @RequestMapping(method = RequestMethod.PUT)
    public void addNewBook(@RequestBody Book book){
        bookRepository.save(book);
        System.out.println(book);
    }

    //GET ALL BOOK
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Book> getAllBooks() {
        log.info("Get all book");
        return bookRepository.findAll();
    }

    //GET A SPECIFIC BOOK
    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable String bookId){
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isPresent()){
            return bookOptional.get();
        }else{
            throw new BookNotFoundException();
        }
    }

    // UPDATE A BOOK
    @RequestMapping(value = "/{bookId}", method = RequestMethod.POST)
    public Book modifyBook(@RequestBody Book book, @RequestBody String bookId ) {
        return bookRepository.save(book);
    }

    // DELETE ALL BOOKS
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBooks() {
        bookRepository.deleteAll();
        log.info("YOUR BOOK COLLECTION IS GONE! REDUCED TO ATOMS!");
    }

    //DELETE A SPECIFIC BOOK
    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable String bookId) {
        bookRepository.deleteById(bookId);
        log.info("BOOK DELETED");
    }



    /*
    @RequestMapping(method= RequestMethod.PUT)
    public void setUser(@RequestBody User user){
        userRepository.save(user);
        System.out.println(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser (@PathVariable String userId){
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isPresent()){
           return userOpt.get();
        }
        else{
            return null;
        }
    }
     */


}
