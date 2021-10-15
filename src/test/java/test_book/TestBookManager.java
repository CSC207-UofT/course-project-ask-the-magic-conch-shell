package test_book;

import Book.Book_position_status;
import Book.Book;
import org.junit.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestBookManager {
    Book book1;
    Book book2;
    LocalDate publishDate1 = LocalDate.of(2001,7,15);
    LocalDate publishDate2 = LocalDate.of(2000,8,11);
    LocalDate returnDate = LocalDate.of(2021,11,1);
    @Before
    public void setUp(){
        book1 = new Book(1,"Iron Man", "123456", publishDate1,"Stan");
        book2 = new Book(2,"Captain American", "654321",publishDate2,"Tiffany");
        book1.setStatus(Book_position_status.UNLENDED);
        book2.setStatus(Book_position_status.LENDED);
        book1.setReturnDate(null);
        book2.setReturnDate(returnDate);
    }

}
