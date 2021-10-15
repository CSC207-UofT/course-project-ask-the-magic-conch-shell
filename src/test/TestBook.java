import Book.Book_position_status;
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
    @Test(timeout = 50)
    public void Book_status_Test1(){
        assertEquals(Book_position_status.UNLENDED, book1.getStatus());
    }
    @Test(timeout = 50)
    public void Book_status_Test2(){
        assertEquals(Book_position_status.UNLENDED, book2.getStatus());
    }
    @Test(timeout = 50)
    public void Book_returnDate_Test1(){
        assertNull(book1.getReturnDate());
    }
    @Test(timeout = 50)
    public void Book_returnDate_Test2(){
        assertNull(book2.getReturnDate());
    }




}
