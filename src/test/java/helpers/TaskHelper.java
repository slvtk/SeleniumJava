package helpers;

import com.google.gson.Gson;
import manager.ApplicationManager;
import models.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//тут не норм
public class TaskHelper extends HelperBase {
    //записи полученные из Json
    private final List<TaskData> tasks = tasksFromJson();
    //записи для изменения
    private final TaskData editedTasks = new TaskData("Изменен", "Изменен");

    public TaskHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    //Получаем лист всех записей с главной страницы
    public List<TaskData> getActualTasks() {

        List<TaskData> createdTasks = new ArrayList<>();
        //количество таблиц в 3 по счету tr для цикла for ниже
        List<WebElement> tables = driver.findElements(By.xpath("//tr[3]/td/table"));
        //проходим по каждой таблице(таблица = запись)
        for (int i = 1; i <= tables.size(); i++) {
            driver.findElement(By.xpath("//td/table[" + i + "]/tbody/tr[2]/td[2]/a")).click();
            String target = driver.findElement(By.xpath("//td/table[" + i + "]/tbody/tr[2]/td[2]/a")).getText();
            String description = driver.findElement(By.xpath("//td/table[" + i + "]/tbody/tr[2]/td[2]/div")).getText();
            createdTasks.add(new TaskData(target, description));
        }
        //отправляем данные созданные тестом, для сравнения в тесте
        return createdTasks;
    }

    //Создаем записи
    public void createTasks() {
        for (TaskData task :
                tasks) {
            driver.findElement(By.linkText("Новая задача")).click();
            driver.findElement(By.xpath("(//input[@name='proj_name'])[2]")).click();
            driver.findElement(By.xpath("(//input[@name='proj_name'])[2]")).clear();
            driver.findElement(By.xpath("(//input[@name='proj_name'])[2]")).sendKeys(task.getTarget());
            driver.findElement(By.xpath("(//textarea[@name='proj_opis'])[2]")).click();
            driver.findElement(By.xpath("(//textarea[@name='proj_opis'])[2]")).clear();
            driver.findElement(By.xpath("(//textarea[@name='proj_opis'])[2]")).sendKeys(task.getDescription());
            driver.findElement(By.xpath("//input[@value='Создать задачу']")).click();
        }
    }

    //Редактируем каждую запись на странице
    public void editTasks() {
        List<WebElement> buttons = driver.findElements(By.xpath("//img[@alt='редактировать']"));
        for (int i = 1; i <= buttons.size(); i++) {
            driver.findElement(By.xpath("(//img[@alt='редактировать'])[" + i + "]")).click();
            driver.findElement(By.name("proj_name")).clear();
            driver.findElement(By.name("proj_name")).sendKeys(editedTasks.getDescription());
            driver.findElement(By.name("proj_opis")).clear();
            driver.findElement(By.name("proj_opis")).sendKeys(editedTasks.getTarget());
            driver.findElement(By.xpath("//input[@value='Сохранить']")).click();
        }
    }

    //Возвращаем данные которые ждем после создания
    public List<TaskData> getExpectedCreatedTasks() {
        return tasks;
    }

    //Возвращаем данные которые ждем после изменения
    public List<TaskData> getExpectedEditedTasks() {
        return Arrays.asList(editedTasks, editedTasks, editedTasks);
    }

    //Преобразуем Json в список TaskData
    private List<TaskData> tasksFromJson() {
        List<TaskData> data = null;
        try {
            FileReader fileReader = new FileReader("example.json");
            BufferedReader reader = new BufferedReader(fileReader);
            Gson gson = new Gson();
            data = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                data.add(gson.fromJson(line, TaskData.class));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
