package processSale.view;

/**
 * This class implements the Logger interface.
 * It prints a message to <code>System.out</code>.
 */

public class ConsoleLogger implements Logger {

    /**
     * Prints a message to <code>System.out</code>.
     * @param msg The message to be logged.
     */
    @Override
    public void log(String msg) {
        System.out.println(msg);
    }

}
