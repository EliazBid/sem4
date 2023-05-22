package processSale.view;

import processSale.controller.Controller;
import processSale.integration.ItemNotFoundException;
import processSale.integration.DatabaseFailureException;
import processSale.model.Amount;

public class View {

	private Logger logger;
	private FileLogger fileLogger = new FileLogger();
	private ConsoleLogger consoleLogger = new ConsoleLogger();
	private Controller contr;
	private Amount amount = new Amount(200); // amount is the money given by the customer

	/**
	 * Creates a new instance.
	 * @param contr The controller that is used for all operations.
	 */
	public View(Controller contr) {
		this.contr = contr;
		contr.addSaleObserver(new TotaleRevenueView());
		contr.addSaleObserver(new TotalRevenueFileOutput());
	}

	private void setLogger(Logger logger ) {
		this.logger = logger;
	}

	/**
	 * Simulates a user input that generates calls to all system operations.
	 * scanItem() is called 6 times to simulate 6 items being scanned.
	 * Numbers 1-10 are used to simulate existing item identifiers.
	 * @throws ItemNotFoundException if an item with the specified identifier does not exist.
	 * @throws DatabaseFailureException if the database is not reachable. This exception is hardcoded to trigger with item identifier 666.
	 */
	public void runProgram(){
		contr.startSale();
		System.out.println("New sale started!\n");

		try{
			contr.scanItem(1); 
		}
		catch (ItemNotFoundException exc) {
			setLogger(consoleLogger);
			logger.log("Item not found, please try again.\n");
		}
		catch (DatabaseFailureException exc) {
			setLogger(fileLogger);
			logger.log("Database could not be reached.");
			setLogger(consoleLogger);
			logger.log("An error has occured. Contact the staff.\n");
		}

		try{
			contr.scanItem(2); 
		}
		catch (ItemNotFoundException exc) {
			setLogger(consoleLogger);
			logger.log("Item not found, please try again.\n");
		}
		catch (DatabaseFailureException exc) {
			setLogger(fileLogger);
			logger.log("Database could not be reached.");
			setLogger(consoleLogger);
			logger.log("An error has occured. Contact the staff.\n");
		}

		try{
			contr.scanItem(3); 
		}
		catch (ItemNotFoundException exc) {
			setLogger(consoleLogger);
			logger.log("Item not found, please try again.\n");
		}
		catch (DatabaseFailureException exc) {
			setLogger(fileLogger);
			logger.log("Database could not be reached.");
			setLogger(consoleLogger);
			logger.log("An error has occured. Contact the staff.\n");
		}

		try{
			contr.scanItem(5); 
		}
		catch (ItemNotFoundException exc) {
			setLogger(consoleLogger);
			logger.log("Item not found, please try again.\n");
		}
		catch (DatabaseFailureException exc) {
			setLogger(fileLogger);
			logger.log("Database could not be reached.");
			setLogger(consoleLogger);
			logger.log("An error has occured. Contact the staff.\n");
		}

		try{
			contr.scanItem(11); 
		}
		catch (ItemNotFoundException exc) {
			setLogger(consoleLogger);
			logger.log("Item not found, please try again.\n");
		}
		catch (DatabaseFailureException exc) {
			setLogger(fileLogger);
			logger.log("Database could not be reached.");
			setLogger(consoleLogger);
			logger.log("An error has occured. Contact the staff.\n");
		}

		try{
			contr.scanItem(666); 
		}
		catch (ItemNotFoundException exc) {
			setLogger(consoleLogger);
			logger.log("Item not found, please try again.\n");
		}
		catch (DatabaseFailureException exc) {
			setLogger(fileLogger);
			logger.log("Database could not be reached.");
			setLogger(consoleLogger);
			logger.log("An error has occured. Contact the staff.\n");
		}
		
		contr.endSale(); 
		contr.enterAmountPaid(amount); 
		
	}
}
