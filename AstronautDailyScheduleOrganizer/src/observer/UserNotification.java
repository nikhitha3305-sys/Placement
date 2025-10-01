package observer;

public class UserNotification implements Observer {
    private final String userName;
    public UserNotification(String userName) {
        this.userName = userName;
    }
    @Override
    public void update(String message) {
        System.out.println("Notification for " + userName + ": " + message);
    }
}
