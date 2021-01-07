package com.example.DemoH2.demoH2.controller;

import com.example.DemoH2.demoH2.bookService.bookService;
import com.example.DemoH2.demoH2.entity.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class bookController {

    @Autowired
    bookService BS;

    @GetMapping("/book")
    public List<book> getAllBooks() {
        return BS.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public book getBookById(@PathVariable("id")int id){
        return BS.getBookById(id);
    }

    @PostMapping("/book")
    public int insertBook(@RequestBody book b) {
        return BS.insertBook(b);
    }

    @DeleteMapping("/book/{id}")
    public int deleteBook(@PathVariable("id")int id) {
        return BS.deleteBook(id);
    }

    @PutMapping("/book/{id}")
    public void updateBook(@PathVariable("id")int id, @RequestBody book b) {
        BS.updateBook(id, b);
    }

}
