package processSale.view;

/** 
 * This interface is implemented by the classes ConsoleLogger and FileLogger.
*/

public interface Logger {
    
    /**
     * This method is implemented by the classes ConsoleLogger and FileLogger.
     * @param msg The message to be logged.
     */
    void log(String msg);
}
