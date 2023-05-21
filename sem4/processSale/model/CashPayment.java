package processSale.model;

public class CashPayment {

	private Amount amount;
	
	/**
	 * creates instance with given amount
	 * @param PaidAmount money given by customer
	 */
	public CashPayment (Amount PaidAmount) {
		this.amount = PaidAmount;
	}
	
	/**
	 * calculates and returns total cost of the sale
	 * @param paidSale the sale that includes the items
	 * @param moneyPaid
	 * @return
	 */
	public Amount calculateTotalCost(Sale paidSale) {
		return paidSale.getRunningTotal();
	}

}
