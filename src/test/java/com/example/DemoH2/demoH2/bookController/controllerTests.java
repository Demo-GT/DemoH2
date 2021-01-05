package com.example.DemoH2.demoH2.bookController;

import com.example.DemoH2.demoH2.bookService.bookService;
import com.example.DemoH2.demoH2.controller.bookController;
import com.example.DemoH2.demoH2.entity.book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@WebMvcTest(bookController.class)
public class controllerTests {

    @Autowired
    MockMvc MMvc;

    @MockBean
    bookService BS;

    @Test
    public void TestGETALL() throws Exception {

        when(BS.getAllBooks()).thenReturn(new ArrayList<book>());

        RequestBuilder RB = MockMvcRequestBuilders
                            .get("/book")
                            .accept(MediaType.APPLICATION_JSON);

        MMvc
                .perform(RB)
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
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

        RequestBuilder RB = MockMvcRequestBuilders
                            .post("/book",b)
                            .accept(MediaType.TEXT_PLAIN);

        MMvc
                .perform(RB)
                .andExpect(status().is(400));

    }

    @Test
    public void TestDELETE() throws Exception {

        book b = new book("wui", "whr");
        RequestBuilder RB = MockMvcRequestBuilders
                            .post("/book", b);

        MMvc
                .perform(RB)
                .andExpect(status().isOk());

    }

}
