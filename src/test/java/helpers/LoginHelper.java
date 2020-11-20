package helpers;

import manager.ApplicationManager;
import models.AccountData;
import org.openqa.selenium.By;
//Тут все норм
public class LoginHelper extends HelperBase {

    private final AccountData user = new AccountData("ss", "ssssssss");

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void signIn() {
        driver.findElement(By.name("ss0")).clear();
        driver.findElement(By.name("ss0")).sendKeys(user.getEmail());
        driver.findElement(By.name("ss00")).clear();
        driver.findElement(By.name("ss00")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//input[@value='Вход']")).click();
    }
}
