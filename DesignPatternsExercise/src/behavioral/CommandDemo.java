package behavioral;

/*
 * Command Pattern demonstration.
 * Use case: Remote control sends commands to a device (e.g. Robot).
 * Command encapsulates a request as an object, letting you parameterize clients with queues,
 * requests, and support undoable operations.
 */

interface Command {
    void execute();
}

class Robot {
    public void start() {
        System.out.println("Robot started.");
    }
    public void stop() {
        System.out.println("Robot stopped.");
    }
}

class StartCommand implements Command {
    private Robot robot;

    public StartCommand(Robot robot) {
        this.robot = robot;
    }

    public void execute() {
        robot.start();
    }
}

class StopCommand implements Command {
    private Robot robot;

    public StopCommand(Robot robot) {
        this.robot = robot;
    }

    public void execute() {
        robot.stop();
    }
}

class RemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void pressButton() {
        slot.execute();
    }
}

public class CommandDemo {
    public static void main(String[] args) {
        Robot robot = new Robot();
        RemoteControl control = new RemoteControl();

        control.setCommand(new StartCommand(robot));
        control.pressButton();

        control.setCommand(new StopCommand(robot));
        control.pressButton();
    }
}
