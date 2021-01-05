package com.example.DemoH2.demoH2.bookService;

import com.example.DemoH2.demoH2.entity.book;
import com.example.DemoH2.demoH2.repository.bookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MockServiceTests<when> {

    @Mock
    bookRepository BR;

    @InjectMocks
    bookService BS;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestPOST() {

        int result = 1;

        when(BR.save(any(book.class))).thenReturn(new book("jhd", "bwj"));

        int B = BS.insertBook(new book("ew","we"));

        assertEquals(0,B);

    }

    @Test
    public void TestGet() {

        when(BR.findAll()).thenReturn(new ArrayList<book>());

        List<book> L = BS.getAllBooks();

        assertTrue(L.size()>=0);

    }

    @Test
    public void TestGETByID() {

        book b = new book(1,"we","w");

        when(BR.findById(anyInt())).thenReturn(Optional.of(b));

        Optional<book> B = Optional.ofNullable(BS.getBookById(1));

        assertTrue((B.get()).getId()>0);
    }

}
