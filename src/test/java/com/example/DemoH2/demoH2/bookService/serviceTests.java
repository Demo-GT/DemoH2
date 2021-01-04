package com.example.DemoH2.demoH2.bookService;


import com.example.DemoH2.demoH2.entity.book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class serviceTests {

    @Autowired
    bookService Bs;

    @Test
    public void SampleRUN() {

        book B = new book(1, "uegsf", "jaudgw");
        Bs.insertBook(B);
        book result = Bs.getBookById(1);
        assertEquals(B.getId(), result.getId());

    }
}
