package model;

public class Task {
    private String name;
    private int startTime; // in minutes since midnight
    private int endTime;   // in minutes since midnight
    private String priority;

    public Task(String name, int startTime, int endTime, String priority) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getName() { return name; }
    public int getStartTime() { return startTime; }
    public int getEndTime() { return endTime; }
    public String getPriority() { return priority; }

    public static int parseTime(String timeStr) {
        if (timeStr == null || !timeStr.matches("\\d{2}:\\d{2}")) return -1;
        String[] parts = timeStr.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) return -1;
        return hour * 60 + minute;
    }

    public static String toTimeString(int minutes) {
        int hour = minutes / 60;
        int min = minutes % 60;
        return String.format("%02d:%02d", hour, min);
    }

    @Override
    public String toString() {
        return String.format("%s: %s-%s [%s]",
                name, toTimeString(startTime), toTimeString(endTime), priority);
    }
}
