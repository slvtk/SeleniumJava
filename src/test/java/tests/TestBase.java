package tests;
//тут все норм

import com.google.gson.Gson;
import configurations.JsonConf;
import configurations.Settings;
import manager.ApplicationManager;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestBase {

    protected ApplicationManager app;
    private final Gson json = new Gson();

    @Before
    public void setApplicationManager() throws FileNotFoundException {
        Settings.init(json.fromJson(new BufferedReader(new FileReader("conf.json")), JsonConf.class));
        System.out.println(json.fromJson(new BufferedReader(new FileReader("conf.json")), JsonConf.class).getDriverName());
        app = ApplicationManager.getInstance();
    }
}
