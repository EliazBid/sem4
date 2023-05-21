package processSale.controller;

import processSale.model.Sale;
import processSale.integration.DatabaseFailureException;
import processSale.integration.ItemNotFoundException;
import processSale.integration.ExternalAccountingSystem;
import processSale.integration.ExternalInventorySystem;
import processSale.model.CashRegister;
import processSale.model.Receipt;
import processSale.model.CashPayment;
import processSale.integration.Printer;
import processSale.integration.RegistryCreator;
import processSale.integration.ItemDTO;
import processSale.model.Amount;

public class Controller {

	private Sale sale;

	private ExternalAccountingSystem externalAccountingSystem;

	private ExternalInventorySystem externalInventorySystem;

	private CashRegister cashRegister;

	private Receipt receipt;

	private Printer printer;
	
	/**
     * Creates an instance of the controller where the references to externals systems are saved.
	 * @param creator The creator of the external systems.
     * @param printer The printer that will print the receipt.
     */
   	public Controller(RegistryCreator creator, Printer printer) {
        this.externalAccountingSystem = creator.getExternalAccountingSystem();
		this.externalInventorySystem = creator.getExternalInventorySystem();
       	this.cashRegister = new CashRegister();
        this.printer = printer;
    }

	/**
	 * Starts a new sale.
	 */
	public void startSale() {
		sale = new Sale();
	}

	/**
	 * Adds and or increases the quantity of the item to the sale and prints the item information.
	 * @param itemIdentifier The identifier of the item, e.g. barcode
	 * @throws ItemNotFoundException If the item is not found in the inventory system
	 * @throws DatabaseFailureException If the database is not reachable
	 */
	public void scanItem(int itemIdentifier) throws ItemNotFoundException, DatabaseFailureException {

		ItemDTO foundItem = externalInventorySystem.findItem(itemIdentifier);
		sale.addItem(foundItem);
		System.out.println("Item information:\nItem name: " + foundItem.getName() + "\nItem price: " + foundItem.getPrice() + "\n");
	}

	/**
	 * Ends the sale. The total price is calculated and returned.
	 */
	public void endSale() {
		Amount runningTotal = sale.getRunningTotal();
		System.out.println("The total price is: " + String.format("%.2f", runningTotal.getAmount()));
	}
	/**
	 * Handles money given by customer to calculate total cost and change, updates external systems and cash register, and prints a finalized receipt if the customer has paid enough money.
	 * @param paidAmount Money given by customer
	 */
	public void enterAmountPaid(Amount paidAmount) {
		CashPayment toPay = new CashPayment(paidAmount);
		sale.pay(toPay,sale);
		updateExternals();
		cashRegister.addMoney(toPay);
		sale.calculateChange(paidAmount);
		if (sale.getChange().getAmount() < 0) {
			System.out.println("The customer has not paid enough money.");
		}
		else {
			receipt = sale.getReceipt(sale,printer);
		} 
		
	}

	/**
	 * Prints the receipt
	 */
	public void printReceipt() {
		printer.printReceipt(receipt);
	}

	/**
	 * Updates external systems
	 */
	public void updateExternals(){
		externalAccountingSystem.updateAccountingSystem(sale);
		externalInventorySystem.updateInventory();
	}

}
