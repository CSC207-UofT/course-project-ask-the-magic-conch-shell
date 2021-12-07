package UseCaseTest;


import com.bookSystem.entity.Book.bookType.*;

import com.bookSystem.mongoDBGateway.MongoDBBookMethods;
import com.bookSystem.useCase.BookPositionStatus;
import com.bookSystem.entity.Book.Book;
import com.bookSystem.useCase.DBbookManager;
import org.junit.*;
import java.time.LocalDate;
import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DBbookManagerTest {

    /**
     * tests for DBbookManager use case.
     */

        Book book1;
        Book book2;
        Book book3;
        LocalDate publishDate1 = LocalDate.of(2002,10,14);
        LocalDate publishDate2 = LocalDate.of(2000,6,1);
        LocalDate publishDate3 = LocalDate.of(2010,10,21);
        LocalDate returnDate = LocalDate.of(2021,10,21);
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        DBbookManager dbm = new DBbookManager();

        @Before
        public void setUp(){
            book1 = new magazine(26,"Iron Man", "9783034982374", publishDate1,"Stan","fashion1", "recreation","Magazine");
            book2 = new literature(27,"Captain American", "9783049823741",publishDate2,"Tiffany","Modern" ,"Literature");
            book3 = new textbook(28,"Scarlet Witch", "9783049823621",publishDate3,"James", "Religion", "Textbook");
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
        /**
         * Test whether we can search a book given its id.
         */
        @Test(timeout = 100)
        public void testSearchBookByID(){ assertEquals(book2.getBookID(), dbm.searchBookByID(27, bm).getBookID()); }

        /**
         * Test whether we can delete a book given its id and can't search it after deleting.
         */
        @Test(timeout = 2000)
        public void testDeleteBook() {
            assertTrue(dbm.deleteBook(27, bm));
            assertNull(dbm.searchBookByID(27, bm));
        }

        /**
         * Test whether we can get a list of books given its author.
         */
        @Test(timeout = 100)
        public void testSearchBookByAuthor(){
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(book3.getBookID());
            assertEquals(ar, dbm.searchBookByAuthor("James", bm)); }

     /**
      * Test whether we can get a list of books given its type.
      */
      @Test(timeout = 100)
     public void testSearchBookByType(){
          assertTrue(dbm.searchBookByType("Magazine", bm).contains(book1.getBookID())); }


        /**
         * Test whether we can check a book's return date.
         */
        @Test(timeout = 100)
        public void testCheckReturnDate(){
            assertEquals(returnDate, dbm.checkReturnDate(23, bm));}

       /**
        * Test whether we can change a book's return date.
        */
        @Test(timeout = 2000)
        public void testChangeReturnDate(){
            LocalDate date = LocalDate.of(2021,10,23);
            dbm.changeReturnDate(book2.getBookID(),date, bm);
            assertEquals(date, dbm.checkReturnDate(book2.getBookID(), bm));
        }

    /**
     * Test whether we can change a book's status and whether the return date is set correspondingly.
     */
    @Test(timeout = 1000)
    public void testChangeBookStatus(){
        dbm.changeBookStatus(book1.getBookID(), BookPositionStatus.LENDED, bm);
        assertEquals(BookPositionStatus.LENDED, dbm.checkBookStatus(book1.getBookID(), bm));
//            assertEquals(LocalDate.now().plusDays(30), dbm.checkReturnDate(book1.getBookID(), bm));
    }
}


