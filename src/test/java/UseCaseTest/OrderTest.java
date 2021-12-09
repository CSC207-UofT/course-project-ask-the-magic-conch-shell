package UseCaseTest;

import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.User.Student;
import com.bookSystem.useCase.BookPositionStatus;
import com.bookSystem.useCase.Order;
import org.junit.Before;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class OrderTest {
    /**
     * Tests for Order Use Case
     **/

    Order order0;
    Order order1;
    Order order2;
    Order order3;
    Book newbook1;
    Book newbook2;
    ArrayList<Integer> empty_record;
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list3 = new ArrayList<>();
    Student student1;
    Student student2;
    Student student3;
    LocalDate date = LocalDate.of(2020, 1, 6);


    @Before
    public void setUp() throws Exception {
        student1 = new Student("Alistar");
        student2 = new Student("Brand");
        student3 = new Student("Corki");
        Collections.addAll(list1, 55, 56, 57, 58, 59);
        Collections.addAll(list2, 60, 61, 62, 63);
        student1.setCreditScore(90);
        student1.setBorrowingRecords(list1);
        student2.setBorrowingRecords(list2);
        student3.setBorrowingRecords(list3);
        student2.setCreditScore(90);
        student3.setCreditScore(5);
        empty_record = new ArrayList<>();
        newbook1 = new Book(1, "Fade", "ds134", date, "Jacob", "Textbook");
        newbook2 = new Book(2, "Scarlet Witch", "9783049823621", date, "James", "Textbook");
        newbook1.setStatus(BookPositionStatus.UNLENDED);
        newbook2.setStatus(BookPositionStatus.LENDED);
        order0 = new Order(newbook2, student2);
        order1 = new Order(newbook1, student1);
        order2 = new Order(newbook1, student2);
        order3 = new Order(newbook1, student3);

    }


    /**
     * Check if book status is Lended
     * */

    @Test
    public void testexecute0() {
        assertFalse(order0.execute());
        assertEquals(student2.getBorrowedBookAmount(), 4);
        assertEquals(newbook2.getStatus(), BookPositionStatus.LENDED);
    }


    /**
     * Check if a student exceed the borrow limit
     * */

    @Test
    public void testexecute1() {
        assertFalse(order1.execute());
        assertEquals(student1.getBorrowedBookAmount(), 5);
        assertEquals(newbook1.getStatus(), BookPositionStatus.UNLENDED);
    }


    /**
     * Check if a student does not have enough credit to borrow
     * */

    @Test
    public void testexecute3() {
        assertFalse(order3.execute());
        assertEquals(student3.getBorrowedBookAmount(), 0);
        assertEquals(newbook1.getStatus(), BookPositionStatus.UNLENDED);
    }


    /**
     * Check if a student satisfies all borrowing requirements and the book is unlended
     * */

    @Test
    public void testexecute2() {
        assertFalse(order2.execute());
        assertEquals(student2.getBorrowedBookAmount(), 4);
        assertEquals(newbook1.getStatus(), BookPositionStatus.UNLENDED);
    }

}
