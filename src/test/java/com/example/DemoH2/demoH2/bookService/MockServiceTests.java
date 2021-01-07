package com.example.DemoH2.demoH2.bookService;

import com.example.DemoH2.demoH2.entity.Book;
import com.example.DemoH2.demoH2.repository.bookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
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
    BookService BS;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestPOST() {

        int result = 1;

        when(BR.save(any(Book.class))).thenReturn(new Book("jhd", "bwj"));

        int B = BS.insertBook(new Book("ew","we"));

        assertEquals(0,B);

    }

    @Test
    public void TestGet() {

        when(BR.findAll()).thenReturn(new ArrayList<Book>());

        List<Book> L = BS.getAllBooks();

        assertTrue(L.size()>=0);

    }

    @Test
    public void TestGETByID() {

        Book b = new Book(1,"we","w");

        when(BR.findById(anyInt())).thenReturn(Optional.of(b));

        Optional<Book> B = Optional.ofNullable(BS.getBookById(1));

        assertTrue((B.get()).getId()>0);
    }

}
