package app;

import service.ScheduleManager;
import service.TaskFactory;
import model.Task;
import observer.UserNotification;

import java.util.Scanner;
import java.util.regex.*;

public class AstronautDailyScheduleOrganizer {
    private static final ScheduleManager manager = ScheduleManager.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        manager.addObserver(new UserNotification("Astronaut"));

        // Main loop: reads input and processes until "exit"
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) break;
            processCommand(input);
        }
        System.out.println("Exiting. Goodbye!");
        scanner.close();
    }

    private static void processCommand(String input) {
        Pattern addPattern = Pattern.compile(
                "^Add Task\\(\"([^\"]+)\",\\s*\"(\\d{2}:\\d{2})\",\\s*\"(\\d{2}:\\d{2})\",\\s*\"(High|Medium|Low)\"\\)$",
                Pattern.CASE_INSENSITIVE);
        Pattern removePattern = Pattern.compile(
                "^Remove Task\\(\"([^\"]+)\"\\)$", Pattern.CASE_INSENSITIVE);
        Pattern viewPattern = Pattern.compile("^View Tasks$", Pattern.CASE_INSENSITIVE);

        Matcher m;

        m = addPattern.matcher(input);
        if (m.matches()) {
            String name = m.group(1);
            int start = Task.parseTime(m.group(2));
            int end = Task.parseTime(m.group(3));
            String priority = capitalize(m.group(4));
            Task task = TaskFactory.createTask(name, start, end, priority);
            manager.addTask(task);
            return;
        }

        m = removePattern.matcher(input);
        if (m.matches()) {
            String name = m.group(1);
            manager.removeTask(name);
            return;
        }

        m = viewPattern.matcher(input);
        if (m.matches()) {
            manager.showTasks();
            return;
        }

        System.out.println("Invalid command format.");
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
