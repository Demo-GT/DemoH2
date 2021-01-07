package com.example.DemoH2.demoH2.bookService;


import com.example.DemoH2.demoH2.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class serviceTests {

    @Autowired
    BookService Bs;

    @Test
    public void TestInsert() {
        Book B = new Book("uegsf", "jaudgw");
        Bs.insertBook(B);
        Book result = Bs.getBookById(2);
        assertEquals(B.getId(), result.getId());
    }

    @Test
    public void TestUpdate() {
        Book B = new Book("qwert","564");
        Bs.updateBook(2,B);
        Book result = Bs.getBookById(2);
        assertEquals(B.getGenre(),result.getGenre());
    }
    
    @Test
    public void TestDelete() {
        Bs.insertBook(new Book("uyq","qu"));
        assertTrue(Bs.deleteBook(1)==1);
    }

    @Test void TestGetAll() {
        assertTrue((Bs.getAllBooks()).size() >= 0);
    }

}


