package processSale.model;

/**
 * An interface for classes that should be notified when a sale is completed.
 */
public interface SaleObserver {
    void UpdateTotalSaleRevenue(Amount finalPrice);
}
