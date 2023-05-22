package processSale.view;

import processSale.model.SaleObserver;
import processSale.model.Amount;

public class TotaleRevenueView implements SaleObserver{
    private Amount totalRevenue = new Amount(0);

    /**
     * Adds the final price of a sale to the total revenue and prints it to system.out.
     */
    public void UpdateTotalSaleRevenue(Amount finalPrice){
        totalRevenue.add(finalPrice);
        System.out.println("Total revenue: " + totalRevenue.getAmount() + " kr");
    }
}
