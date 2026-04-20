package JavaApplication2;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testUsernameCorrect() {
        boolean result = login.checkUserName("kyl_1");
        assertTrue(result);
    }

    @Test
    public void testUsernameIncorrect() {
        boolean result = login.checkUserName("kyle123");
        assertFalse(result);
    }

    @Test
    public void testPasswordCorrect() {
        boolean result = login.checkPasswordComplexity("Ch&kkk9!");
        assertTrue(result);
    }

    @Test
    public void testPasswordIncorrect() {
        boolean result = login.checkPasswordComplexity("password");
        assertFalse(result);
    }

    @Test
    public void testCellNumberCorrect() {
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertTrue(result);
    }

    @Test
    public void testCellNumberIncorrect() {
        boolean result = login.checkCellPhoneNumber("0896653");
        assertFalse(result);
    }

    @Test
    public void testLoginSuccess() {
        login.registerUser("kyl_1", "Ch&kkk9!", "+27838968976");
        boolean result = login.loginUser("kyl_1", "Ch&kkk9!");
        assertTrue(result);
    }

    @Test
    public void testLoginFail() {
        login.registerUser("kyl_1", "Ch&kkk9!", "+27838968976");
        boolean result = login.loginUser("kyl_1", "wrongPass");
        assertFalse(result);
    }
}
