// TestSingleton.java
public class TestSingleton {
    public static void main(String[] args) {
        // Get the instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Test the Singleton implementation
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }

        // Use the Logger to log messages
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
    }
}
