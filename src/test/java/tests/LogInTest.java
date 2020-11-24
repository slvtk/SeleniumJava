package tests;

import org.junit.*;

//тут все норм
public class LogInTest extends TestBase {
    @Test
    public void logIn() {
        app.getLoginHelper().logIn();
    }

    @Test
    public void loginWithValidData() {
        app.getLoginHelper().logInWithValidData();
        app.getLoginHelper().logOut();
    }

    @Test
    public void loginWithInvalidData() {
        app.getLoginHelper().logInWithInvalidData();
    }
}
