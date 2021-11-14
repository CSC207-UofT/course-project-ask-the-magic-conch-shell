package UseCaseTest;

import MongoDBGateway.MongoDBBookMethods;
import UseCase.BookPositionStatus;
import Book.Book;
import org.junit.*;
import java.time.LocalDate;
import MongoDBGateway.IMongoDBBookMethods;
import UseCase.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DBbookManagerTest {

        Book book1;
        Book book2;
        Book book3;
        LocalDate publishDate1 = LocalDate.of(2002,10,14);
        LocalDate publishDate2 = LocalDate.of(2000,6,1);
        LocalDate publishDate3 = LocalDate.of(2010,10,21);
        LocalDate returnDate = LocalDate.of(2021,10,21);;
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        DBbookManager dbm = new DBbookManager();

        @Before
        public void setUp(){
            book1 = new Book(1,"Iron Man", "9783034982374", publishDate1,"Stan", "Textbook");
            book2 = new Book(2,"Captain American", "9783049823741",publishDate2,"Tiffany", "Literature");
            book3 = new Book(3,"Scarlet Witch", "9783049823621",publishDate3,"James", "Literature");
            book1.setStatus(BookPositionStatus.UNLENDED);
            book2.setStatus(BookPositionStatus.LENDED);
            book3.setStatus(BookPositionStatus.UNLENDED);
            book1.setReturnDate(null);
            book2.setReturnDate(returnDate);
            book3.setReturnDate(null);
            dbm.addBook(book1,bm);
            dbm.addBook(book2,bm);
            dbm.addBook(book3,bm);
        }

        @Test(timeout = 100)
        public void testSearchBookByID(){ assertEquals(dbm.searchBookByID(2, bm), book2); }

        @Test(timeout = 100)
        public void testDeletBook(){
            dbm.deleteBook(2, bm);
            assertNull(dbm.searchBookByID(2, bm)); }

        @Test(timeout = 100)
        public void testSearchBookByAuthor(){
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(book3.getBookID());
            assertEquals(dbm.searchBookByAuthor("James", bm), ar); }

        @Test(timeout = 100)
        public void testSearchBookByType(){
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(book2.getBookID());
            ar.add(book3.getBookID());
            assertEquals(dbm.searchBookByType("Literature", bm), ar); }

        @Test(timeout = 100)
        public void testCheckReturnDate(){assertEquals(dbm.checkReturnDate(book2.getBookID(), bm), returnDate);}

        @Test(timeout = 100)
        public void testChangeReturnDate(){
            LocalDate date = LocalDate.of(2021,10,10);
            dbm.changeReturnDate(book2.getBookID(),date, bm);
            assertEquals(dbm.checkReturnDate(book2.getBookID(), bm),date);
        }

        @Test(timeout = 100)
        public void testChangeBookStatus(){
            assertTrue(dbm.changBookStatus(book1.getBookID(), BookPositionStatus.LENDED, bm));
            assertEquals(dbm.checkReturnDate(book1.getBookID(), bm),LocalDate.now().plusDays(30));
        }
    }
