package processSale.model;

import java.time.LocalTime;

import processSale.integration.ItemDTO;
import java.util.ArrayList;

public class Receipt {

	private LocalTime timeOfSale;

	private ArrayList<ItemDTO> itemList;

	private Amount runningTotal;

	private Amount change;

	/**
	 * Constructor that makes a receipt with the given sale information.
	 */
	public Receipt() {
		this.timeOfSale = LocalTime.now();
		this.itemList = new ArrayList<ItemDTO>();
		this.runningTotal = new Amount(0);
		this.change = new Amount(0);
	}

	/**
	 * Constructor that makes a receipt with the given sale information.
	 * @param sale The sale that is to be added to the receipt.
	 */
	public Receipt(Sale sale) {
		this.timeOfSale = sale.getTimeOfSale();
		this.itemList = sale.getItemList();
		this.runningTotal = sale.getRunningTotal();
		this.change = sale.getChange();
	}

	/**
	 * Returns the time of the sale.
	 */
	public LocalTime getTimeOfSale() {
		return this.timeOfSale;
	}

	/**
	 * Returns the list of items in the sale.
	 */
	public ArrayList<ItemDTO> getItemList() {
		return this.itemList;
	}

	/**
	 * Returns the running total of the sale.
	 */
	public Amount getRunningTotal() {
		return this.runningTotal;
	}

	/**
	 * Returns the change of the sale.
	 */
	public Amount getChange() {
		return this.change;
	}

	
}
