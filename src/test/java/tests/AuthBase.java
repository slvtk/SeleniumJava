package tests;

import org.junit.Before;

public class AuthBase extends TestBase {

    @Before
    public void setUp() {
        app.getLoginHelper().logIn();
    }
}
