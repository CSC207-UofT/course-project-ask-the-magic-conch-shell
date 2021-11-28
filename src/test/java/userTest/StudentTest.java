package userTest;

import com.bookSystem.entity.Book.Book;

import com.bookSystem.entity.User.Student;
import org.junit.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class StudentTest {
    Student h;
    Student j;
    ArrayList<Book> empty_record;
    Book book1;
    LocalDate date = LocalDate.of(2020, 1, 8);
    @Before
    public void setUp() throws Exception {
        h = new Student("Harry");
        j = new Student("Jason");
        j.CreditScoreSetter(30);
        empty_record= new ArrayList<>();
        book1 = new Book(1,"Fade","ds134", date, "Jacob", "Textbook");
        j.AddToCurrentBorrowingRecords(book1);
    }

    @Test(timeout = 50)
    public void TestStudentCredit(){

        assertEquals(30, j.CreditScoreGetter());
    }

    @Test(timeout = 50)
    public void TestStudentCredit2(){

        assertEquals(100, h.CreditScoreGetter());
    }

    @Test(timeout = 50)
    public void TestStudentBorrowingRecord(){

        assertEquals(empty_record, h.CurrentBorrowingRecordsGetter());
    }

    @Test(timeout = 50)
    public void TestStudentBorrowingRecord1(){

        assertEquals(book1, j.CurrentBorrowingRecordsGetter().get(0));
    }

}
