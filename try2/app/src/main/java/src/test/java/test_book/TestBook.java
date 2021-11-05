package src.test.java.test_book;

import Book.BookPositionStatus;
import Book.Book;
import org.junit.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestBook {
    Book book1;
    Book book2;
    LocalDate publishDate1 = LocalDate.of(2001,7,15);
    LocalDate publishDate2 = LocalDate.of(2000,8,11);
    LocalDate returnDate;
    @Before
    public void setUp(){
        book1 = new Book(1,"Iron Man", "123456", publishDate1,"Stan");
        book2 = new Book(2,"Captain American", "654321",publishDate2,"Tiffany");
        book1.setStatus(BookPositionStatus.UNLENDED);
        book2.setStatus(BookPositionStatus.LENDED);
        book1.setReturnDate(null);
        book2.setReturnDate(returnDate);
    }
    @Test(timeout = 50)
    public void testStatus1(){
        assertEquals(BookPositionStatus.UNLENDED, book1.getStatus());
    }
    @Test(timeout = 50)
    public void testStatus2(){
        assertEquals(BookPositionStatus.LENDED, book2.getStatus());
    }
    @Test(timeout = 50)
    public void testReturnDate1(){
        assertNull(book1.getReturnDate());
    }
    @Test(timeout = 50)
    public void testReturnDate2(){
        assertEquals(returnDate, book2.getReturnDate());
    }



}
