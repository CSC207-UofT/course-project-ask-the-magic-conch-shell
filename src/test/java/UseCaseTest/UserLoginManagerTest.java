package UseCaseTest;

import com.application.UseCase.IUserLoginManager;
import com.application.UseCase.UserLoginManager;
import com.application.Entity.User.Student;
import com.application.Entity.User.Staff;
import org.junit.*;
import static org.junit.Assert.*;

public class UserLoginManagerTest {
    Student a = new Student("Martin");
    Staff c = new Staff("Jason");
    IUserLoginManager ulm1 = new UserLoginManager(a);
    IUserLoginManager ulm2 = new UserLoginManager(c);


    @Before
    public void setUp() throws Exception {
        a.CreditScoreSetter(100);
    }

    @Test
    public void testModifyCreditScore() {
        ulm1.modifyCreditScore(-5);
        assertEquals(95, a.CreditScoreGetter());
    }

    @Test
    public void testStudentModifyPassword() {
        a.PasswordSetter("martin666");
        ulm1.studentModifyPassword("Martin", "martin666", "martin789");
        assertEquals("martin789", a.PasswordGetter("Martin"));
    }

    @Test
    public void testStaffModifyPassword() {
        c.PasswordSetter("a123456");
        ulm2.staffModifyPassword("Jason", "a123456", "a654321");
        assertEquals("a654321", c.PasswordGetter("Jason"));

    }

}
