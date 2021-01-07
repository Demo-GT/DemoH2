package com.example.DemoH2.demoH2.controller;

import com.example.DemoH2.demoH2.bookService.BookService;
import com.example.DemoH2.demoH2.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    BookService BS;

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return BS.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id")int id){
        return BS.getBookById(id);
    }

    @PostMapping("/book")
    public int insertBook(@RequestBody Book b) {
        return BS.insertBook(b);
    }

    @DeleteMapping("/book/{id}")
    public int deleteBook(@PathVariable("id")int id) {
        return BS.deleteBook(id);
    }

    @PutMapping("/book/{id}")
    public void updateBook(@PathVariable("id")int id, @RequestBody Book b) {
        BS.updateBook(id, b);
    }

}
