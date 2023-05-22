package processSale.view;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalTime;

public class FileLogger implements Logger {

    private static final String LOG_FILE_NAME = "ProcessSaleLog.txt";
    private PrintWriter logStream;

    /**
     * Creates a new instance of logStream.
     */
    public FileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
        } 
        catch (IOException ioe) {
            System.out.println("CAN NOT LOG.");
            ioe.printStackTrace();
        }
    }

    @Override
    public void log(String msg) {
        logStream.println(msg + " Occured at: " + LocalTime.now());

    }
    
}
