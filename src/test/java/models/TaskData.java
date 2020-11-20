package models;

//тут норм
public class TaskData {
    private final String target;
    private final String description;

    public TaskData(String target, String description) {
        this.target = target;
        this.description = description;
    }

    public String getTarget() {
        return target;
    }

    public String getDescription() {
        return description;
    }
}
