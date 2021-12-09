package bookTest;

import com.bookSystem.useCase.BookPositionStatus;
import com.bookSystem.entity.Book.Book;
import org.junit.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestBook {

    /**
     * Tests for Book Entity.
     */

    Book book1;
    Book book2;
    Book book3;
    LocalDate publishDate1 = LocalDate.of(2001,7,15);
    LocalDate publishDate2 = LocalDate.of(2000,8,11);
    LocalDate publishDate3 = LocalDate.of(2011,12,1);
    LocalDate returnDate1;
    LocalDate returnDate2 = LocalDate.of(2021,12,3);

    @Before
    public void setUp(){
        book1 = new Book(1,"Iron Man", "123456", publishDate1,"Stan", "Literature");
        book2 = new Book(2,"Captain American", "654321",publishDate2,"Tiffany", "Literature");
        book3 = new Book(3,"Rocket", "482212341",publishDate3,"Elon", "Textbook");
        book1.setStatus(BookPositionStatus.UNLENDED);
        book2.setStatus(BookPositionStatus.LENDED);
        book3.setStatus(BookPositionStatus.UNLENDED);
        book1.setReturnDate(null);
        book2.setReturnDate(returnDate1);
        book3.setReturnDate(returnDate2);
    }

    @Test(timeout = 50)
    public void getId(){ assertEquals(1, book1.getBookID()); }
    @Test(timeout = 50)
    public void getISBN(){ assertEquals("123456", book1.getISBN()); }
    @Test(timeout = 50)
    public void getPublishdate(){ assertEquals(publishDate2, book2.getPublishDate()); }
    @Test(timeout = 50)
    public void getauthor(){ assertEquals("Elon", book3.getAuthor()); }
    @Test(timeout = 50)
    public void testStatus1(){ assertEquals(BookPositionStatus.UNLENDED, book1.getStatus()); }
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
        assertEquals(returnDate1, book2.getReturnDate());
    }
    @Test(timeout = 50)
    public void testReturnDate3(){
        assertEquals(returnDate2, book3.getReturnDate());
    }




}
