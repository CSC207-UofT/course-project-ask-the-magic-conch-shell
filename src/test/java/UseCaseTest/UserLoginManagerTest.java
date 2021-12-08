
package UseCaseTest;


import com.bookSystem.entity.User.Staff;
import com.bookSystem.entity.User.Student;
import com.bookSystem.useCase.IUserLoginManager;
import com.bookSystem.useCase.UserLoginManager;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserLoginManagerTest {
    ArrayList<Integer> arr = new ArrayList<>();
    UserLoginManager ulm1;
    UserLoginManager ulm2;

    @Before
    public void setUp() throws Exception {
        arr.add(10);
        arr.add(11);
        //ulm1 = new UserLoginManager("Martin", "aae9e13", 40, arr);
        //ulm2 = new UserLoginManager("Jason", "e3r23r3");
    }

    @Test
    public void testModifyCreditScore() {
        ulm1.modifyCreditScore(-5);
        //assertEquals(35, ulm1.currentStudent.CreditScoreGetter());
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
        //assertEquals(2, ulm1.BorrowedBookAmount());
    }

}

