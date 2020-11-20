package manager;

import helpers.TaskHelper;
import helpers.LoginHelper;
import helpers.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

//тут все норм
public class ApplicationManager {

    private final WebDriver driver;
    private final StringBuffer verificationErrors = new StringBuffer();
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;
    public TaskHelper taskHelper;
    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>();

    private ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        String baseUrl = "http://www.mainplans.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(this, baseUrl);
        loginHelper = new LoginHelper(this);
        taskHelper = new TaskHelper(this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop() {
        driver.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public TaskHelper getTaskHelper() {
        return taskHelper;
    }

    public static ApplicationManager getInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.navigationHelper.openIndexPage();
            app.set(newInstance);
        }
        return app.get();
    }

}
