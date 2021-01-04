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
    private List<book> getAllBooks() {
        return BS.getAllBooks();
    }

    @GetMapping("/book/{id}")
    private book getBookById(@PathVariable("id")int id){
        return BS.getBookById(id);
    }

    @PostMapping("/book")
    private int insertBook(@RequestBody book b) {
        BS.insertBook(b);
        return b.getId();
    }

    @DeleteMapping("/book/{id}")
    private void deleteBook(@PathVariable("id")int id) {
        BS.deleteBook(id);
    }

    @PutMapping("/book/{id}")
    private void updateBook(@PathVariable("id")int id, @RequestBody book b) {
        BS.updateBook(id, b);
    }

}
