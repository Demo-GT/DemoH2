package com.example.DemoH2.demoH2.bookController;

import com.example.DemoH2.demoH2.bookService.bookService;
import com.example.DemoH2.demoH2.controller.bookController;
import com.example.DemoH2.demoH2.entity.book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@WebMvcTest(bookController.class)
public class controllerTests {

    @Autowired
    MockMvc MMvc;

    @Autowired
    bookController BC;

    @MockBean
    bookService BS;

    @Test
    public void TestGETALL() throws Exception {

        when(BS.getAllBooks()).thenReturn(new ArrayList<book>());

        List<book> L = BC.getAllBooks();

        assertEquals(0,L.size());

        /*RequestBuilder RB = MockMvcRequestBuilders
                            .get("/book")
                            .accept(MediaType.APPLICATION_JSON);

        MMvc
                .perform(RB)
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));*/
    }

    @Test
    public void TestGET() throws Exception {

        when(BS.getBookById(anyInt())).thenReturn(new book());

        RequestBuilder request = MockMvcRequestBuilders
                .get("/book/1")
                .accept(MediaType.APPLICATION_JSON);

        MMvc
                .perform(request)
                .andExpect(status().isOk());
    }


    @Test
    public void TestPOST() throws Exception {

        book b = new book("wei", "weu");
        when(BS.insertBook(any(book.class))).thenReturn(0);

        int result = BC.insertBook(b);

        assertEquals(0,result);

        /*RequestBuilder RB = MockMvcRequestBuilders
                            .post("/book",b)
                            .accept(MediaType.TEXT_PLAIN);

        MMvc
                .perform(RB)
                .andExpect(status().is(200));*/

    }

    @Test
    public void TestDELETE() throws Exception {

        book b = new book("wui", "whr");

        when(BS.deleteBook(anyInt())).thenReturn(1);

        int c = BC.deleteBook(1);

        assertEquals(1,c);

        /*RequestBuilder RB = MockMvcRequestBuilders
                            .delete("/book", 1);

        MMvc
                .perform(RB)
                .andExpect(status().isOk());*/

    }

}
