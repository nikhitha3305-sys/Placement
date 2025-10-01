package creational;

/*
 * Singleton Pattern demonstration.
 * Use case: Configuration manager ensures a single instance throughout the application.
 * Singleton restricts the instantiation of a class to one object, providing a global point of access.
 */

class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
        // private constructor
    }

    public static synchronized ConfigurationManager getInstance() {
        if(instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void showConfig() {
        System.out.println("Showing configuration settings.");
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        config1.showConfig();

        System.out.println("config1 and config2 are the same instance: " + (config1 == config2));
    }
}
