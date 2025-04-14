package MxolisiMaluleka;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    public LoginTest() {
    }

    
    @Test
    public void testCheckpasswordcomplexity() {
        assertTrue(Login.checkpasswordcomplexity("Strong@1"));
        assertFalse(Login.checkpasswordcomplexity("weakpass")); // missing uppercase, digit, special char
    }

    @Test
    public void testCheckingtheSAcellnumber() {
        assertTrue(Login.checkingtheSAcellnumber("+27831234567"));
        assertFalse(Login.checkingtheSAcellnumber("0831234567")); // missing +27
    }

    @Test
    public void testUserRegistration() {
        Login login = new Login();
        Registration.firstname = "Mxolisi";
        Registration.lastname = "Maluleka";

        // Valid
        String successMsg = login.UserRegistration("jd_1", "Password@1", "+27831234567");
        assertEquals("YOUR ACCOUNT REGISTRATION IS COMPLETE AND SUCCESSFUL , PLEASE LOG IN.", successMsg);

        // Invalid username
        String failUsername = login.UserRegistration("MXOVA", "Password@1", "+27831234567");
        assertTrue(failUsername.contains("INCORRECT USERNAME FORMAT"));

        // Invalid password
        String failPassword = login.UserRegistration("mxova", "pass", "+27831234567");
        assertTrue(failPassword.contains("THIS PASSWORD IS INVALID"));

        // Invalid number
        String failNumber = login.UserRegistration("jd_1", "Password@1", "0831234567");
        assertTrue(failNumber.contains("INVALID CELLPHONE NUMBER"));
    }

    @Test
    public void testLogintheuser() {
        Login login = new Login();
        Login.database.put("jd_1", "Password@1");

        assertTrue(login.Logintheuser("jd_1", "Password@1"));
        assertFalse(login.Logintheuser("jd_1", "WrongPass"));
    }

    @Test
    public void testLoginStatusreturner() {
        Login login = new Login();
        Registration.firstname = "Mxolisi";
        Registration.lastname = "Maluleka";

        String success = login.LoginStatusreturner(true);
        assertTrue(success.contains("WELCOME BACK"));

        String failure = login.LoginStatusreturner(false);
        assertTrue(failure.contains("INCORRECT USERNAME OR PASSWORD"));
    }
}