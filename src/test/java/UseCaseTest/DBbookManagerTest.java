package UseCaseTest;

import Book.subclasses.Literature;
import Book.subclasses.Textbook;
import MongoDBGateway.MongoDBBookMethods;
import UseCase.BookPositionStatus;
import Book.Book;
import org.junit.*;
import java.time.LocalDate;
import MongoDBGateway.IMongoDBBookMethods;
import UseCase.*;
import org.junit.jupiter.api.AfterAll;

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
            book1 = new Textbook(26,"Iron Man", "9783034982374", publishDate1,"Stan","Engineering" ,"Textbook");
            book2 = new Literature(27,"Captain American", "9783049823741",publishDate2,"Tiffany","Modern" ,"Literature");
            book3 = new Textbook(28,"Scarlet Witch", "9783049823621",publishDate3,"James", "Religion", "Textbook");
//            book1 = new Book(1,"Iron Man", "9783034982374", publishDate1,"Stan" ,"Textbook");
//            book2 = new Book(2,"Captain American", "9783049823741",publishDate2,"Tiffany" ,"Literature");
//            book3 = new Book(3,"Scarlet Witch", "9783049823621",publishDate3,"James", "Literature");

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
        /*
         * Test whether we can search a book given its id.
         */
        @Test(timeout = 100)
        public void testSearchBookByID(){ assertEquals(book2.getBookID(), dbm.searchBookByID(27, bm).getBookID()); }

        /*
         * Test whether we can delete a book given its id and can't search it after deleting.
         */
        @Test(timeout = 1000)
        public void testDeleteBook() {
            assertTrue(dbm.deleteBook(27, bm));
            assertNull(dbm.searchBookByID(2, bm));
        }

        /*
         * Test whether we can get a list of books given its author.
         */
        @Test(timeout = 100)
        public void testSearchBookByAuthor(){
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(book3.getBookID());
            assertEquals(ar, dbm.searchBookByAuthor("James", bm)); }

        /*
         * Test whether we can get a list of books given its type.
         */
        @Test(timeout = 100)
        public void testSearchBookByType(){
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(book1.getBookID());
            ar.add(book3.getBookID());
            assertEquals(ar, dbm.searchBookByType("Textbook", bm)); }

        /*
         * Test whether we can check a book's return date.
         */
        @Test(timeout = 100)
        public void testCheckReturnDate(){assertEquals(returnDate, dbm.checkReturnDate(book2.getBookID(), bm));}

       /*
        * Test whether we can change a book's return date.
        */
        @Test(timeout = 2000)
        public void testChangeReturnDate(){
            LocalDate date = LocalDate.of(2021,10,10);
            dbm.changeReturnDate(book2.getBookID(),date, bm);
            assertEquals(date, dbm.checkReturnDate(book2.getBookID(), bm));
        }

        /*
         * Test whether we can change a book's status and whether the return date is set correspondingly.
         */
        @Test(timeout = 100)
        public void testChangeBookStatus(){
            dbm.changBookStatus(book1.getBookID(), BookPositionStatus.LENDED, bm);
            assertEquals(BookPositionStatus.LENDED, book1.getStatus());
//            assertEquals(LocalDate.now().plusDays(30), dbm.checkReturnDate(book1.getBookID(), bm));
        }
    }
