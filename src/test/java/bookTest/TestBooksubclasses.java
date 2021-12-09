package bookTest;

import com.bookSystem.entity.Book.bookType.*;
import com.bookSystem.useCase.BookPositionStatus;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestBooksubclasses {

    /**
     * Tests for subclasses of Book Entity.
     */

    literature book1;
    magazine book2;
    textbook book3;
    researchPaper book4;
    dictionary book5;
    LocalDate publishDate1 = LocalDate.of(2001,7,15);
    LocalDate publishDate2 = LocalDate.of(2000,8,11);
    LocalDate publishDate3 = LocalDate.of(2011,12,1);
    LocalDate publishDate4 = LocalDate.of(2002,6,5);
    LocalDate publishDate5 = LocalDate.of(1998,1,22);
    LocalDate returnDate1;
    LocalDate returnDate2 = LocalDate.of(2021,12,3);

    @Before
    public void setUp() {
        book1 = new literature(1, "Iron Man", "123456", publishDate1, "Stan", "Modern", "Literature");
        book2 = new magazine(2, "Marvel Super Hero", "654321", publishDate2, "Tiffany", "Captain American", "cartoon", "Magazine");
        book3 = new textbook(3, "Rocket", "482212341", publishDate3, "Elon","Aerospace" ,"Textbook");
        book4 = new researchPaper(4, "Complex Analysis", "3551351432", publishDate4, "Cauchy","Math" ,"English",true,"ResearchPaper");
        book5 = new dictionary(5, "Easy French", "482212341", publishDate5, "Oxford Press","French" ,"Dictionary");

        book1.setStatus(BookPositionStatus.UNLENDED);
        book2.setStatus(BookPositionStatus.LENDED);
        book3.setStatus(BookPositionStatus.UNLENDED);
        book4.setStatus(BookPositionStatus.LENDED);
        book4.setStatus(BookPositionStatus.LENDED);
        book1.setReturnDate(null);
        book2.setReturnDate(returnDate1);
        book3.setReturnDate(returnDate2);
        book4.setReturnDate(null);
        book4.setReturnDate(null);
    }

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
    @Test(timeout = 50)
    public void testLiteraturePeriod(){
        assertEquals("Modern", book1.getPeriod());
    }
    @Test(timeout = 50)
    public void testMagazineSeriesName(){
        assertEquals("Captain American", book2.getSeriesName());
    }
    @Test(timeout = 50)
    public void testTextbookSubject(){
        assertEquals("Aerospace", book3.getSubject());
    }
    @Test(timeout = 50)
    public void testResearchPaperSubject(){
        assertEquals("Math", book4.getSubject());
    }
    @Test(timeout = 50)
    public void testResearchPaperLanguage(){
        assertEquals("English", book4.getLanguage());
    }
    @Test(timeout = 50)
    public void testResearchPaperPeerReviewStatus(){
        assertTrue(book4.getPeerReviewStatus());
    }
    @Test(timeout = 50)
    public void testDictionaryLanguage(){
        assertEquals("French", book5.getLanguage());
    }
}

