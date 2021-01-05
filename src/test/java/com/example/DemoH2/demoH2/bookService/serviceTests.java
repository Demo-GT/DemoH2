package com.example.DemoH2.demoH2.bookService;


import com.example.DemoH2.demoH2.entity.book;
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
    bookService Bs;

    @Test
    public void TestInsert() {
        book B = new book("uegsf", "jaudgw");
        Bs.insertBook(B);
        book result = Bs.getBookById(2);
        assertEquals(B.getId(), result.getId());
    }

    @Test
    public void TestUpdate() {
        book B = new book("qwert","564");
        Bs.updateBook(2,B);
        book result = Bs.getBookById(2);
        assertEquals(B.getGenre(),result.getGenre());
    }
    
    @Test
    public void TestDelete() {
        Bs.insertBook(new book("uyq","qu"));
        assertTrue(Bs.deleteBook(1)==1);
    }

    @Test void TestGetAll() {
        assertTrue((Bs.getAllBooks()).size() >= 0);
    }

}


