package main;

public class Task {
    private int id;
    private String taskName;
    private Status taskStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
