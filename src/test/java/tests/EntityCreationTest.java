package tests;

import com.google.gson.Gson;
import models.TaskData;
import org.junit.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class EntityCreationTest extends TestBase {

    public static List<TaskData> dataFromJson() throws IOException {
        FileReader fileReader = new FileReader("example.json");
        BufferedReader reader = new BufferedReader(fileReader);
        Gson gson = new Gson();
        List<TaskData> data = new ArrayList<>();
        String line = reader.readLine();
        while (line!=null){
            data.add(gson.fromJson(line, TaskData.class));
            line = reader.readLine();
        }
        System.out.println(data);
        return data;
    }

    @Test
    public void entityCreationTest() throws IOException {
        List<TaskData> taskData = dataFromJson();
        app.getTaskHelper().createTask();
        TaskData task = app.getTaskHelper().getTestTaskData();
        TaskData createdTask = app.getTaskHelper().getCreatedTaskData();
        Assert.assertEquals(task.getTarget(),createdTask.getTarget());
        Assert.assertEquals(task.getDescription(),createdTask.getDescription());
    }
}