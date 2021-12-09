/*
package UseCaseTest;
import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.User.Student;
import com.bookSystem.useCase.BookPositionStatus;
import com.bookSystem.useCase.Order;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class OrderTest {
    */
/**
    Tests for Order Use Case
     *//*

    Order u;
    Order order0;
    Order order1;
    Order order2;
    Order order3;
    Book newbook1;
    Book newbook2;
    ArrayList<Integer> empty_record;
    ArrayList<Integer> list1;
    ArrayList<Integer> list2;
    ArrayList<Integer> list3;
    Student student1;
    Student student2;
    Student student3;
    LocalDate date = LocalDate.of(2020, 1, 6);


    @Before
    public void setUp() throws Exception {
        Student student1 = new Student("Alistar");
        Student student2 = new Student("Brand");
        Student student3 = new Student("Corki");
        Collections.addAll(list1, 55, 56, 57, 58, 59);
        Collections.addAll(list2, 60, 61, 62, 63);
        student1.setCreditScore(90);
        student1.setBorrowingRecords(list1);
        student2.setBorrowingRecords(list2);
        student3.setBorrowingRecords(list3);
        student2.setCreditScore(90);
        student3.setCreditScore(5);
        ArrayList empty_record = new ArrayList<>();
        Book newbook1 =  new Book(1, "Fade", "ds134", date, "Jacob", "Textbook");
        Book newbook2 = new Book(2,"Scarlet Witch", "9783049823621",date,"James", "Textbook");
        newbook1.setStatus(BookPositionStatus.UNLENDED);
        newbook2.setStatus(BookPositionStatus.LENDED);
        Order order0 = new Order(newbook2, student2);
        Order order1 = new Order(newbook1, student1);
        Order order2 = new Order(newbook1, student2);
        Order order3 = new Order(newbook1, student3);

    }

    */
/**
     * Check if book status is Lended
     *//*


    @Test
    public void testexecute0() {
        assertFalse(order0.execute());
        assertEquals(student2.getBorrowedBookAmount(), 4);
        assertEquals(newbook2.getStatus(), BookPositionStatus.LENDED);
    }

    */
/**
     * Check if a student exceed the borrow limit
     *//*


    @Test
    public void testexecute1(){
        assertFalse(order1.execute());
        assertEquals(student1.getBorrowedBookAmount(), 5);
        assertEquals(newbook1.getStatus(), BookPositionStatus.UNLENDED);
    }

    */
/**
     * Check if a student does not have enough credit to borrow
     *//*


    @Test
    public void testexecute3(){
        assertFalse(order3.execute());
        assertEquals(student3.getBorrowedBookAmount(), 0);
        assertEquals(newbook1.getStatus(), BookPositionStatus.UNLENDED);
    }

    */
/**
     * Check if a student satisfies all borrowing requirements and the book is unlended
     *//*


    @Test
    public void testexecute2(){
        assertTrue(order2.execute());
        assertEquals(student2.getBorrowedBookAmount(), 5);
        assertEquals(newbook1.getStatus(), BookPositionStatus.LENDED);
    }

}
*/
