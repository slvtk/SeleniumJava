package manager;

import configurations.Settings;
import helpers.TaskHelper;
import helpers.LoginHelper;
import helpers.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final WebDriver driver;
    private final StringBuffer verificationErrors = new StringBuffer();
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;
    public TaskHelper taskHelper;
    private static final ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    private ApplicationManager() {
        System.setProperty(Settings.driverName, Settings.driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(this, Settings.baseUrl);
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
