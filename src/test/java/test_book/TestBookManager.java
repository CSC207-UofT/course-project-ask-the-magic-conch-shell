package test_book;

import Book.Book;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBookManager {
    Book book1;
    Book book2;
    ArrayList<Book> allBooks = new ArrayList<>();


    @Before
    public void setUp(){
        ArrayList<Book> allBooks = new ArrayList<>();

    }

    @Test
    public void testaddBook(){
        allBooks.add(book1);
        allBooks.add(book2);
        assertEquals(book1, allBooks.get(0));
        assertEquals(book2, allBooks.get(1));
        Assert.assertEquals(2, allBooks.size());
    }

    @Test
    public void testdeleteBook(){
        allBooks.add(book1);
        allBooks.add(book2);
        assertTrue( allBooks.remove(book2));
        Assert.assertEquals(1, allBooks.size());
    }


}
