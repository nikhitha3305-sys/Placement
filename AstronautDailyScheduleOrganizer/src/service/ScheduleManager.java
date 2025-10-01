package service;

import model.Task;
import observer.Observer;
import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    private ScheduleManager() {}

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public boolean addTask(Task newTask) {
        if (newTask.getStartTime() < 0 || newTask.getEndTime() < 0 || newTask.getStartTime() >= newTask.getEndTime()) {
            notifyObservers("Error: Invalid time for new task.");
            return false;
        }
        for (Task t : tasks) {
            if (isConflict(t, newTask)) {
                notifyObservers("Error: Task '" + newTask.getName() + "' conflicts with existing task '" + t.getName() + "'.");
                return false;
            }
        }
        tasks.add(newTask);
        notifyObservers("Task '" + newTask.getName() + "' added successfully.");
        return true;
    }

    private boolean isConflict(Task t1, Task t2) {
        return !(t1.getEndTime() <= t2.getStartTime() || t2.getEndTime() <= t1.getStartTime());
    }

    public boolean removeTask(String name) {
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            Task t = it.next();
            if (t.getName().equalsIgnoreCase(name)) {
                it.remove();
                notifyObservers("Task '" + name + "' removed successfully.");
                return true;
            }
        }
        notifyObservers("Error: Task '" + name + "' not found.");
        return false;
    }

    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        tasks.sort(Comparator.comparingInt(Task::getStartTime));
        System.out.println("Current Scheduled Tasks:");
        for (Task t : tasks) {
            System.out.println(" - " + t);
        }
    }
}
