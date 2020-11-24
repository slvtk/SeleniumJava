package configurations;

public class JsonConf {

    private String login;
    private String password;
    private String incorrectLogin;
    private String incorrectPassword;
    private String baseUrl;
    private String driverName;
    private String driverPath;
    private String editedTarget;
    private String editedDescription;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getIncorrectLogin() {
        return incorrectLogin;
    }

    public String getIncorrectPassword() {
        return incorrectPassword;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public String getEditedTarget() {
        return editedTarget;
    }

    public String getEditedDescription() {
        return editedDescription;
    }
}
