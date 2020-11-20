package tests;
//тут все норм
import manager.ApplicationManager;
import org.junit.Before;

public class TestBase {

    protected ApplicationManager app;
    @Before
    public void setApplicationManager(){
        app = ApplicationManager.getInstance();
    }
}
