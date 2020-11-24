package configurations;

import java.io.*;

public class Settings {
    public static String login;
    public static String password;
    public static String incorrectLogin;
    public static String incorrectPassword;
    public static String baseUrl;
    public static String driverName;
    public static String driverPath;
    public static String editedTarget;
    public static String editedDescription;

    public static void init(JsonConf settings) {
        login = settings.getLogin();
        password = settings.getPassword();
        incorrectLogin = settings.getIncorrectLogin();
        incorrectPassword = settings.getIncorrectPassword();
        baseUrl = settings.getBaseUrl();
        driverName = settings.getDriverName();
        driverPath = settings.getDriverPath();
        editedTarget = settings.getEditedTarget();
        editedDescription = settings.getEditedDescription();
    }
}
