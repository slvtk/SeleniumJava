package tests;

import models.TaskData;
import org.junit.*;

import java.util.*;

public class EntityCreationTest extends TestBase {

    @Test
    public void entityCreationTest() {
        //создаем записи
        app.getTaskHelper().createTasks();
        //тут записи из json
        List<TaskData> expectedData = app.getTaskHelper().getExpectedCreatedTasks();
        expectedData.forEach(e-> System.out.println(e.getTarget()));
        //тут записи, которые получены после создания
        List<TaskData> actualData = app.getTaskHelper().getActualTasks();
        actualData.forEach(e-> System.out.println(e.getTarget()));
        //переопределили equals() и hashCode() для метода containsAll()
        Assert.assertTrue(expectedData.containsAll(actualData));
    }
}