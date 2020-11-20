package tests;

import org.junit.*;
//тут все норм
public class DraftTest extends TestBase {

    @Test
    public void testDraft() throws Exception {
    app.getNavigationHelper().openIndexPage();
    app.getLoginHelper().signIn();
    }
}
