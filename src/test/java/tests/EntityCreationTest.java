package tests;

import models.TaskData;
import org.junit.*;

import java.util.*;

public class EntityCreationTest extends AuthBase {

    @Test
    public void entityCreationTest() {
        //создаем записи
        app.getTaskHelper().createTasks();
        //тут записи из json
        List<TaskData> expectedData = app.getTaskHelper().getExpectedCreatedTasks();
        //тут записи, которые получены после создания
        List<TaskData> actualData = app.getTaskHelper().getActualTasks();
        //переопределили equals() и hashCode() для метода containsAll()
        Assert.assertTrue(expectedData.containsAll(actualData));
    }
}