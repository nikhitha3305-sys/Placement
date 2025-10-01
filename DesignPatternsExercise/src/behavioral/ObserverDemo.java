package behavioral;

import java.util.*;

/*
 * Observer Pattern demonstration.
 * Use case: A task manager notifies registered user observers about task changes.
 * Observer defines a one-to-many dependency so that when one object changes state,
 * all its dependents are notified and updated automatically.
 *
 * This pattern promotes loose coupling and event-driven design.
 */

interface Observer {
    void update(String message);
}

class UserNotification implements Observer {
    private String user;

    public UserNotification(String user) {
        this.user = user;
    }

    @Override
    public void update(String message) {
        System.out.println(user + " received notification: " + message);
    }
}

class TaskManager {
    private List<Observer> observers = new ArrayList<>();
    private List<String> tasks = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers("New task added: " + task);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        UserNotification user1 = new UserNotification("Alice");
        UserNotification user2 = new UserNotification("Bob");

        manager.addObserver(user1);
        manager.addObserver(user2);

        manager.addTask("Complete assignment");
        manager.addTask("Read design patterns");
    }
}
