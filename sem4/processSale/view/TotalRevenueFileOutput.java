package processSale.view;

import processSale.model.SaleObserver;
import processSale.model.Amount;

public class TotalRevenueFileOutput implements SaleObserver{
    private Amount totalRevenue = new Amount(0);
    public void UpdateTotalSaleRevenue(Amount finalPrice){
        totalRevenue.add(finalPrice);
        System.out.println("Total revenue: " + totalRevenue.getAmount() + " USD");
    }
}
