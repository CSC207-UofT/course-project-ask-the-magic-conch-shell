package book;

import org.junit.*;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookManagerTest {
    Book book1;
    Book book2;
    LocalDate publishDate1 = LocalDate.of(2001,7,15);
    LocalDate publishDate2 = LocalDate.of(2000,8,11);
    LocalDate returnDate;
    ArrayList<Book> all_books = new ArrayList<>();
    BookManager bm= new BookManager();
    LocalDate desire_date =  LocalDate.of(2022,1,20);


    @Before
    public void setUp(){
        bm.all_books= new ArrayList<>();
        book1 = new Book(1,"Iron Man", "123456", publishDate1,"Stan");
        book2 = new Book(2,"Captain American", "654321",publishDate2,"Tiffany");
        book1.setStatus(BookPositionStatus.UNLENDED);
        book2.setStatus(BookPositionStatus.LENDED);
        book1.setReturnDate(null);
        book2.setReturnDate(returnDate);
        all_books.add(book1);
        all_books.add(book2);

    }

    @Test
    public void testaddBook(){
        assertEquals(book1, all_books.get(0));
        assertEquals(book2, all_books.get(1));
        assertTrue(all_books.size()==2);
    }

    @Test
    public void testdeleteBook(){
        assertTrue( all_books.remove(book2));
        assertTrue(all_books.size() == 1);
    }

    @Test
    public void testsearchBook(){
        assertTrue(bm.searchBook("123456").contains(1));

    }

    @Test
    public void testcheckInventory(){
        assertEquals(1,bm.checkInventory("123456"));
    }

    @Test
    public void testCheckReturnDate(){
        assertEquals(null, bm.checkReturnDate(1));
    }

    @Test
    public void testChangeReturnDate(){
        bm.changeReturnDate(1, desire_date);
        assertEquals(desire_date, book1.getReturnDate());
    }

    @Test
    public void testChangeBookStatus(){
        bm.changBookStatus(1, BookPositionStatus.LENDED);
        assertEquals(BookPositionStatus.LENDED, book1.getStatus());
    }


}
