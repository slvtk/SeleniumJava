package helpers;

import configurations.Settings;
import manager.ApplicationManager;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void logIn() {
        if (isLoggedIn()) {
            if (isLoggedIn(Settings.login)) {
                return;
            }
            logOut();
        }
        driver.findElement(By.name("ss0")).clear();
        driver.findElement(By.name("ss0")).sendKeys(Settings.login);
        driver.findElement(By.name("ss00")).clear();
        driver.findElement(By.name("ss00")).sendKeys(Settings.password);
        driver.findElement(By.xpath("//input[@value='Вход']")).click();
    }

    public void logInWithValidData() {
        driver.findElement(By.name("ss0")).clear();
        driver.findElement(By.name("ss0")).sendKeys(Settings.login);
        driver.findElement(By.name("ss00")).clear();
        driver.findElement(By.name("ss00")).sendKeys(Settings.password);
        driver.findElement(By.xpath("//input[@value='Вход']")).click();
    }

    public void logInWithInvalidData() {
        driver.findElement(By.name("ss0")).clear();
        driver.findElement(By.name("ss0")).sendKeys(Settings.incorrectLogin);
        driver.findElement(By.name("ss00")).clear();
        driver.findElement(By.name("ss00")).sendKeys(Settings.incorrectPassword);
        driver.findElement(By.xpath("//input[@value='Вход']")).click();
    }


    public boolean isLoggedIn() {
        return driver.findElements(By.className("login")).size() != 0;
    }

    public boolean isLoggedIn(String username) {
        return driver.findElement(By.xpath("//td[4]/div")).getText().equals(username);
    }

    public void logOut() {
        driver.findElement(By.xpath("//input[@value='Выход']")).click();
    }
}
