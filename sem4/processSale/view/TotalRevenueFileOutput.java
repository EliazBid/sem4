package processSale.view;

import processSale.model.SaleObserver;
import processSale.model.Amount;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalTime;

public class TotalRevenueFileOutput implements SaleObserver{

    private Amount totalRevenue = new Amount(0);

    private static final String LOG_FILE_NAME = "SaleRevenueLog.txt";
    private PrintWriter logStream;

    /**
     * Adds the final price of a sale to the total revenue and prints it to a file.
     */
    public void UpdateTotalSaleRevenue(Amount finalPrice){
        totalRevenue.add(finalPrice);
        printSaleRevenueToFile();     
}

private void printSaleRevenueToFile(){
    try {
        logStream = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
    } 
    catch (IOException ioe) {
        System.out.println("CAN NOT LOG.");
        ioe.printStackTrace();
    }
    logStream.println("Total revenue: " + totalRevenue + " Occured at: " + LocalTime.now());
}
}
