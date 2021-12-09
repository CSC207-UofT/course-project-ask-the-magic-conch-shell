package userTest;

import com.bookSystem.entity.User.Staff;
import org.junit.*;

import static org.junit.Assert.*;


public class StaffTest {

    /**
     * Tests for Staff from the user Entity.
     */


    Staff h;

    @Before
    public void setUp() throws Exception {
        h = new Staff("Jason");
        h.setPassword("123");
    }

    @Test(timeout = 50)
    public void TestStaffName(){
        assertEquals("Jason", h.getUsername());
    }

    @Test(timeout = 50)
    public void TestStaffGetPassword(){
        assertEquals("123", h.getPassword());
    }

}
