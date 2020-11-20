package tests;

import models.TaskData;
import org.junit.Assert;
import org.junit.Test;

public class EntityEditionTest extends TestBase{

    @Test
    public void entityEditionTest(){
        app.getNavigationHelper().openIndexPage();
        app.getTaskHelper().editTask();
        TaskData data = app.getTaskHelper().getExpectedEditedData();
        app.getTaskHelper().saveEditedTask();
        TaskData newData = app.getTaskHelper().getEditedTaskData();
        Assert.assertEquals(data.getTarget(),newData.getTarget());
        Assert.assertEquals(data.getDescription(),newData.getDescription());
        app.stop();
    }
}
