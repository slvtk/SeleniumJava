package models;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "TaskData{" +
                "target='" + target + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskData taskData = (TaskData) o;
        return target.equals(taskData.target) && description.equals(taskData.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(target, description);
    }
}
