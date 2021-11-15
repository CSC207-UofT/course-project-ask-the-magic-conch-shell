package UseCaseTest;

import UseCase.IUserLoginManager;
import UseCase.UserLoginManager;
import User.Student;
import User.Staff;
import org.junit.*;
import static org.junit.Assert.*;

public class UserLoginManagerTest {
    Student a = new Student("Martin");
    Staff c = new Staff("Jason");
    IUserLoginManager ulm1= new UserLoginManager(a);
    IUserLoginManager ulm2= new UserLoginManager(c);

    @Before
    public void setUp() throws Exception {
        a.CreditScoreSetter(100);
    }

    @Test
    public void testmodifyCreditScore(){
        ulm1.modifyCreditScore(-5);
        assertEquals(95, a.CreditScoreGetter());
    }
    @Test
    public void teststudentModifyPassword(){
        ulm1.studentModifyPassword("Martin","maritin666","martin789");
        assertEquals("martin789", a.PasswordGetter("Martin"));
    }
    @Test
    public void teststaffModifyPassword(){
        ulm2.staffModifyPassword("Jason","123456","654321");
        assertEquals("654321", c.PasswordGetter("Jason"));
    }

}
