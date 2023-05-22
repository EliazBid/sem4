package processSale.model;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import processSale.integration.ItemDTO;
import processSale.integration.Printer;

public class Sale {

	private LocalTime saleTime;

	private Amount runningTotal = new Amount(0);

	private Amount change;

	private ArrayList<ItemDTO> itemList;

	private Receipt receipt;

	private List<SaleObserver> saleObservers = new ArrayList<>();

	/**
	 * Creates a new instance of a sale. The time of the sale is set to the current time. A new receipt is created.
	 */
	public Sale() {
		itemList = new ArrayList<ItemDTO>();
		setTimeOfSale();
		receipt = new Receipt();
	}
	/**
	 * Sets the time of the sale to the current time.
	 */
	private void setTimeOfSale() {
		saleTime = LocalTime.now();
	}


	/**
	 * Calculates the change to be given to the customer.
	 * @param paidAmount The amount of money given by the customer.
	 */
	public void calculateChange(Amount paidAmount){
		change = paidAmount;
		change.subtract(runningTotal);
	}

	/**
	 * Adds an item to the sale. If the item is already in the sale, the quantity of the item is increased by one.
	 * @param itemDTO	The item to be added to the sale.
	 */
	public void addItem(ItemDTO itemDTO) {
		checkIfDuplicates(itemDTO);
		if (!itemList.contains(itemDTO)){
			itemList.add(0, itemDTO);
		}
		double vat = itemDTO.getVAT();
		Amount price = itemDTO.getPrice();
		Amount priceWithVat = new Amount(price.getAmount() * vat);

		runningTotal.add(priceWithVat);
	}

	/**
	 * Adds an item and its quantity to the sale. Used in the case of multiple items of the same type. 
	 * Never actually used in the program since alternative flow 3-4c is not to be implemented.
	 * @param quantity the multiple of the item
	 * @param itemDTO  the item to be added
	 */
	public void addItem(int quantity, ItemDTO itemDTO) {

	}

	/**
	 * Returns the running total of the sale.
	 */
	public Amount getRunningTotal() {
		return runningTotal;
	}

	/**
	 * Returns the time of the sale.
	 */
	public LocalTime getTimeOfSale() {
		return saleTime;
	}

	/**
	 * Returns the change to be given to the customer.
	 */
	public Amount getChange() {
		return change;
	}

	/**
	 * Returns the list of items in the sale.
	 */
	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}

	private void checkIfDuplicates(ItemDTO ItemDTO) {
		if (itemList.contains(ItemDTO)) {
			int index = itemList.indexOf(ItemDTO);
			itemList.get(index).increaseQuantity();
		}
	}
	/**
	 * Calls method to calculate total cost and saves the cashpayment.
	 * @param toPay money given by customer
	 * @param sale current sale
	 */
	public void pay(CashPayment toPay, Sale sale) {
		toPay.calculateTotalCost(sale);
		notifyObservers();
	}

	private void notifyObservers() {
		for (SaleObserver obs : saleObservers) {
			obs.UpdateTotalSaleRevenue(runningTotal);
		}

	}

	public void addSaleObservers(List<SaleObserver> observers) {
		saleObservers.addAll(observers);
	}

	/**
	 * Creates a finalized receipt, prints it, and returns the receipt.
	 * @param sale current sale reference
	 * @param printer printer reference
	 * @return The finalalized receipt
	 */
	public Receipt getReceipt(Sale sale, Printer printer) {
		Receipt finalReceipt = new Receipt(sale);
		printer.printReceipt(finalReceipt);
		return finalReceipt;
	}

}
