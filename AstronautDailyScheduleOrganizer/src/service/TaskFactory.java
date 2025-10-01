package service;

import model.Task;

public class TaskFactory {
    public static Task createTask(String name, int startTime, int endTime, String priority) {
        return new Task(name, startTime, endTime, priority);
    }
}
