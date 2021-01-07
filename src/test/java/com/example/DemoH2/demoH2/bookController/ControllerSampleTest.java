package com.example.DemoH2.demoH2.bookController;

import com.example.DemoH2.demoH2.bookService.BookService;
import com.example.DemoH2.demoH2.controller.BookController;
import com.example.DemoH2.demoH2.entity.Book;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ControllerSampleTest {

    @Autowired
    private BookController BC;
    @Mock
    private BookService BS;
    @Before
    public void setUp() {
        BC = new BookController();
        Whitebox.setInternalState(BC, "BS", BS);
    }
    @Test
    public void testGETALL() throws Exception {
        when(BS.getAllBooks()).thenReturn(new ArrayList<Book>());
        List<Book> actualBookList = BC.getAllBooks();
        assertEquals(0, actualBookList.size());
    }

}
