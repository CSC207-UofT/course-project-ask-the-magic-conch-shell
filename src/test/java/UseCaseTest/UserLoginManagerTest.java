
package UseCaseTest;


import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.User.Staff;
import com.bookSystem.entity.User.Student;
import com.bookSystem.useCase.IUserLoginManager;
import com.bookSystem.useCase.Order;
import com.bookSystem.useCase.UserLoginManager;
import org.junit.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserLoginManagerTest {
    Student a = new Student("Martin");
    Staff b = new Staff("Jason");
    ArrayList<Integer> arr = new ArrayList<>();
    UserLoginManager ulm1 = new UserLoginManager();
    UserLoginManager ulm2 = new UserLoginManager();
    LocalDate publishDate1 = LocalDate.of(2001,7,15);
    Book book1 = new Book(1,"Iron Man", "123456", publishDate1,"Stan", "Literature");
    Order o1 = new Order(book1, a);

    @Before
    public void setUp() throws Exception {
        arr.add(10);
        arr.add(11);
        a.setPassword("aae9e13");
        b.setPassword("e3r23r3");
        a.setBorrowingRecords(arr);
        a.setCreditScore(40);
        ulm1.setCurrentStudent(a);
        ulm2.setCurrentStaff(b);
    }

    @Test
    public void testgetCurrentStudent() {
        assertEquals(a, ulm1.getCurrentStudent());
    }

    @Test
    public void testgetCurrentStaff() {
        assertEquals(b, ulm2.getCurrentStaff());
    }

    @Test
    public void testModifyCreditScore() {
        ulm1.modifyCreditScore(-5);
        assertEquals(35, ulm1.currentStudent.getCreditScore());
    }

    @Test
    public void testStudentModifyPassword() {
        ulm1.studentModifyPassword("Martin", "aae9e13", "martin789");
        assertEquals("martin789", ulm1.currentStudent.getPassword());
    }

    @Test
    public void testStaffModifyPassword() {
        ulm2.staffModifyPassword("Jason", "e3r23r3", "a654321");
        assertEquals("a654321", ulm2.currentStaff.getPassword());

    }

    @Test
    public void testBorrowedBookAmount() {
        assertEquals(2, ulm1.borrowedBookAmount());
    }

    @Test
    public void testaddToBookList(){
        ulm1.addToBookList(book1);
        assertEquals(1, ulm1.getBookList().size());
    }

    @Test
    public void testaddToCart(){
        ulm1.addToCart(o1);
        assertEquals(1, ulm1.getCart().size());
    }

    @Test
    public void testplaceOrders(){
        ulm1.addToCart(o1);
        ArrayList<Boolean> ar1 = new ArrayList<>();
        ar1.add(false);
        assertEquals(ar1, ulm1.placeOrders());
    }

}

