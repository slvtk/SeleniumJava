package tests;

import models.TaskData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EntityEditionTest extends AuthBase {

    @Test
    public void entityEditionTest() {
        //Редактируем записи
        app.getTaskHelper().editTasks();
        //Получаем то, что мы ожидаем
        List<TaskData> expectedData = app.getTaskHelper().getExpectedEditedTasks();
        //Получаем реальные значения на странице
        List<TaskData> actualData = app.getTaskHelper().getActualTasks();
        //содержит ли список ожидаемых данных, список данных, которые мы получили
        Assert.assertTrue(expectedData.containsAll(actualData));
        app.stop();
    }
}
