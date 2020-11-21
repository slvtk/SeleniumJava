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

    public void logIn() {
//        System.out.println("1");
//        if (isLoggedIn()){
//            System.out.println("2");
//            if (isLoggedIn(user.getEmail())){
//                System.out.println("3");
//                return;
//            }
//            logOut();
//        }
        driver.findElement(By.name("ss0")).clear();
        driver.findElement(By.name("ss0")).sendKeys(user.getEmail());
        driver.findElement(By.name("ss00")).clear();
        driver.findElement(By.name("ss00")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//input[@value='Вход']")).click();
    }

    public boolean isLoggedIn() {
        System.out.println(driver.findElements(By.xpath("//input[@value='Выход']")));
        return driver.findElements(By.xpath("//input[@value='Выход']")).size() != 0;
    }

    public boolean isLoggedIn(String username) {
        return driver.findElement(By.xpath("//td[4]/div")).getText().equals(username);
    }

    public void logOut() {
        driver.findElement(By.xpath("//input[@value='Выход']")).click();
    }
}
