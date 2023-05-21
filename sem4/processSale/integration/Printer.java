package processSale.integration;

import processSale.model.Receipt;

public class Printer {

	/**
    * Creates an instance of the printer.
 	*/
    public Printer() {
        
	}

    /**
     * Prints the receipt into the terminal.
     * @param receipt The receipt to be printed.
 	 */
	public void printReceipt(Receipt receipt) {
		System.out.println("===========================");
		System.out.println("Reciept:");
		System.out.println("The total is: " + String.format("%.2f", receipt.getRunningTotal().getAmount()));
		System.out.println("The change is: " + String.format("%.2f", receipt.getChange().getAmount()));
		System.out.println("The time of sale is: " + receipt.getTimeOfSale());
		for (ItemDTO item : receipt.getItemList()) {
			System.out.println("Item: " + item.getName() + ", Quantity: " + item.getQuantity() + ", Price: " + item.getFinalPrice() + ", VAT: " + item.getVAT());
			
		}
	}

}
