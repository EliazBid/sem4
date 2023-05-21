package processSale.integration;

public class ItemNotFoundException extends Exception {
    
    /**
     * Creates an instance of the exception.
     * @param message The message of the exception.
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
} 
