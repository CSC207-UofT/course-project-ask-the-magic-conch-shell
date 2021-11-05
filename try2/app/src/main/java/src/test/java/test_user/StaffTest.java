package src.test.java.test_user;

import User.Staff;
import org.junit.*;

import static org.junit.Assert.*;


public class StaffTest {
    Staff h;

    @Before
    public void setUp() throws Exception {
        h = new Staff("Jason");
        h.PasswordSetter(123);
    }

    @Test(timeout = 50)
    public void TestStaffName(){
        assertEquals("Jason", h.UsernameGetter());
    }

    @Test(timeout = 50)
    public void TestStaffGetPassword(){
        assertEquals(123, h.PasswordGetter("Jason"));
    }

}
