package UseCaseTest;

import Entity.Book.Book;
import MongoDBGateway.MongoDBStaffMethods;
import MongoDBGateway.MongoDBStudentMethods;
import Entity.User.Staff;
import Entity.User.Student;
import org.junit.Before;
import org.junit.Test;
import UseCase.DBUserManager;
import MongoDBGateway.IMongoDBStudentMethods;
import MongoDBGateway.IMongoDBStaffMethods;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;


public class DBUserManagerTest {
    /**
     * tests for DBUserManager use case.
     */

    DBUserManager UserManager;
    IMongoDBStudentMethods StudentMethods;
    IMongoDBStaffMethods StaffMethods;
    Student h;
    Student j;
    Staff s;
    String password;
    ArrayList<Book> empty_record;
    Book book1;
    LocalDate date = LocalDate.of(2020, 1, 8);

    @Before
    public void setUp() throws Exception {
        h = new Student("Harry");
        j = new Student("Jason");
        s = new Staff("Staff1");
        s.PasswordSetter("123");
        password = "123";
        j.CreditScoreSetter(30);
        empty_record = new ArrayList<>();
        book1 = new Book(1, "Fade", "ds134", date, "Jacob", "Textbook");
        j.AddToCurrentBorrowingRecords(book1);
        UserManager = new DBUserManager();
        StudentMethods = new MongoDBStudentMethods();
        StaffMethods = new MongoDBStaffMethods();
    }

    /**
     * check if student is in the database
     */
    @Test
    public void TestCheckStudent() {
        assertTrue(UserManager.checkStudent("Mike", StudentMethods));}
    /**
     * check what if a student that is not in the database
     */
    @Test
    public void TestCheckStudent1() {
        assertFalse(UserManager.checkStudent("13221365ad", StudentMethods));}
    /**
     * check if staff is in the database
     */
    @Test
    public void TestCheckStaff() {
        assertFalse(UserManager.checkStaff("13221365ad", StaffMethods));}
    /**
     * check what if a staff that is not in the database
     */
    @Test
    public void TestCheckStaff2() {
        assertTrue(UserManager.checkStaff("Veme", StaffMethods));}
    /**
     * test if creating a student works
     */
    @Test
    public void TestCreateStudent() {
        UserManager.createNewUser(h,StudentMethods);
        assertTrue(UserManager.checkStudent("Harry", StudentMethods));
    }
    /**
     * test if creating a staff works
     */
    @Test
    public void TestCreateStaff() {
        UserManager.createNewUser(s,StaffMethods);
        assertTrue(UserManager.checkStaff("Staff1", StaffMethods));
    }
    /**
     * test if can access that created staff password
     */
    @Test
    public void TestCreateStaffPassword() {
        String result = UserManager.staffDBGetPassword("Staff1", StaffMethods);
        assertEquals("123", result);
    }

    /**
     * test getting a password from a student
     */
    @Test
    public void TestStudentPassword() {
        String result = UserManager.studentDBGetPassword("Mike", StudentMethods);
        assertEquals("mik12345", result);
    }

    /**
     * test getting a credit score from a student
     */
    @Test
    public void TestStudentGetCreditScore() {
        long result = UserManager.DBGetCreditScore("test",StudentMethods);
        assertEquals(90, result);
    }
    /**
     * test getting a credit score from another student
     */
    @Test
    public void TestStudentGetCreditScore2() {
        long result = UserManager.DBGetCreditScore("81william",StudentMethods);
        assertEquals(100, result);
    }

    /**
     * test getting a Borrowing History from a student
     */
    @Test
    public void TestStudentGetBorrowingHistory() {
        ArrayList<String> result = UserManager.DBGetBorrowingRecord("Mike",StudentMethods);
        ArrayList<String> test = new ArrayList<>();
        test.add("00006");
        test.add("00007");
        assertEquals(test, result);
    }
    /**
     * test modify password for a student
     */
    @Test
    public void TestStudentModifyPassword() {
        UserManager.studentDBModifyPassword("81william","wil8549458","w123",StudentMethods);
        String result = UserManager.studentDBGetPassword("Mike", StudentMethods);
        assertEquals("mik12345", result);
    }
    /**
     * test delete a student
     */
    @Test
    public void TestStudentDelete() {
        UserManager.deleteStudent("Wang2389",StudentMethods);
        assertFalse(UserManager.checkStudent("Wang2389", StudentMethods));
    }
    /**
     * test Modify a student's borrowingHistory
     */
    @Test
    public void TestStudentModifyBorrowingHistory() {

        ArrayList<String> test = new ArrayList<>();
        test.add("00006");
        test.add("00007");
        test.add("0008");
        UserManager.studentDBModifyBorrowRecord("Eric342",test,StudentMethods);
        ArrayList<String> result = UserManager.DBGetBorrowingRecord("Eric342",StudentMethods);
        assertEquals(test, result);
    }
}