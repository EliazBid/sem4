package processSale.integration;

public class DatabaseFailureException extends Exception{
    
    /**
     * Creates a new instance representing the condition described in the specified message.
     * @param msg A message that describes what went wrong.
     */
    public DatabaseFailureException(String msg) {
        super(msg);
    }
}
