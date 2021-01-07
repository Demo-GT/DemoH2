package com.example.DemoH2.demoH2.bookService;


import com.example.DemoH2.demoH2.entity.Book;
import com.example.DemoH2.demoH2.exceptions.BookIsAlreadyInStack;
import com.example.DemoH2.demoH2.exceptions.BookNotFound;
import com.example.DemoH2.demoH2.repository.bookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    public static final Logger L = LoggerFactory.getLogger(BookService.class);
    @Autowired
    bookRepository BR;
    @Autowired
    JdbcTemplate jdbc;

    @SuppressWarnings("StreamToLoop")
    public List<Book> getAllBooks() {
        return new ArrayList<Book>(BR.findAll());
    }

    public Book getBookById(int id) {
        String S = "Returning Book for id " + id;
        L.info(S);
        Book B = BR.findById(id).get();
        if(B.checkBook())
            throw new BookNotFound();
        return B;

        /*Optional<book> B = jdbc.query("select * " + " from book " + " where id =?", id);
        if(!(b.getClass().equals(book.class)))
            throw new BookNotFound();
        return b;*/
    }

    public int insertBook(Book b) {
        String S = "The Following Book is inserted < ID : "+b.getId()+"  Name : "+b.getName()+"  Genre : "+b.getGenre() + ">";
        L.info(S);
        Optional<Book> B = BR.findByName(b.getName());
        if(B.isPresent())
            throw new BookIsAlreadyInStack();
        BR.save(b);
        return b.getId();
    }

    public int deleteBook(int id) {
        BR.deleteById(id);
        String S = "The Following Book is Deleted Successfully "+id;
        L.info(S);
        return 1;
    }

    public void updateBook(int id, Book b) {
       /* book B = getBookById(id);
        B.setId(b.getId());
        B.setName(b.getName());
        B.setGenre(b.getGenre());
        BR.save(B);*/
        jdbc.update("update book " + " set GENRE = ?, NAME = ? " + " where ID = ? ", b.getGenre(),b.getName(), id);
    }
}
