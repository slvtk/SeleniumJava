package helpers;

import manager.ApplicationManager;
import models.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

//тут не норм
public class TaskHelper extends HelperBase {

    private final TaskData task = new TaskData("Hello, world!", "This is my first topic");

    public TaskHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createTask() {
        driver.findElement(By.linkText("Новая задача")).click();
        driver.findElement(By.xpath("(//input[@name='proj_name'])[2]")).click();
        driver.findElement(By.xpath("(//input[@name='proj_name'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@name='proj_name'])[2]")).sendKeys(task.getTarget());
        driver.findElement(By.xpath("(//textarea[@name='proj_opis'])[2]")).click();
        driver.findElement(By.xpath("(//textarea[@name='proj_opis'])[2]")).clear();
        driver.findElement(By.xpath("(//textarea[@name='proj_opis'])[2]")).sendKeys(task.getDescription());
        driver.findElement(By.xpath("//input[@value='Создать задачу']")).click();
    }

    //Тут просто возвращаем данные которые хотим получить(ВЫШЕ)
    public TaskData getTestTaskData() {
        return task;
    }

    //Тут данные, которые создаются в результате отправки заполненной нами формы
    public TaskData getCreatedTaskData() {
        driver.findElement(By.xpath("//img[@alt='редактировать']")).click();
        driver.findElement(By.xpath("//div/table/tbody/tr[4]")).getText();
        String target = driver.findElement(By.xpath("//div/table/tbody/tr[1]/td[2]/input")).getAttribute("value");
        String description = driver.findElement(By.xpath("//div/table/tbody/tr[4]/td[2]")).getText();
        return new TaskData(target, description);
    }

    public void editTask(){
        driver.findElement(By.xpath("//img[@alt='редактировать']")).click();
        driver.findElement(By.xpath("//div/table/tbody/tr")).click();
        driver.findElement(By.name("proj_name")).clear();
        driver.findElement(By.name("proj_name")).sendKeys("Edited");
        driver.findElement(By.xpath("//body")).click();
        driver.findElement(By.name("proj_opis")).clear();
        driver.findElement(By.name("proj_opis")).sendKeys("Edited");
    }

    public TaskData getExpectedEditedData(){
        String target = driver.findElement(By.name("proj_name")).getAttribute("value");
        String description = driver.findElement(By.name("proj_opis")).getAttribute("value");
        return new TaskData(target, description);
    }

    public void saveEditedTask(){
        driver.findElement(By.xpath("//input[@value='Сохранить']")).click();
    }

    public TaskData getEditedTaskData(){
        driver.findElement(By.xpath("//img[@alt='редактировать']")).click();
        driver.findElement(By.xpath("//div/table/tbody/tr[4]")).getText();
        String target = driver.findElement(By.xpath("//div/table/tbody/tr[1]/td[2]/input")).getAttribute("value");
        String description = driver.findElement(By.xpath("//div/table/tbody/tr[4]/td[2]")).getText();
        return new TaskData(target, description);
    }


}
