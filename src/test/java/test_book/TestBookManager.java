package test_book;

import Book.Book;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBookManager {
    Book book1;
    Book book2;
    ArrayList<Book> all_books = new ArrayList<>();


    @Before
    public void setUp(){
        ArrayList<Book> all_books = new ArrayList<>();

    }

    @Test
    public void testaddBook(){
        all_books.add(book1);
        all_books.add(book2);
        assertEquals(book1, all_books.get(0));
        assertEquals(book2, all_books.get(1));
        Assert.assertEquals(2, all_books.size());
    }

    @Test
    public void testdeleteBook(){
        all_books.add(book1);
        all_books.add(book2);
        assertTrue( all_books.remove(book2));
        Assert.assertEquals(1, all_books.size());
    }


}
