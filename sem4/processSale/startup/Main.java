package processSale.startup;

import processSale.controller.Controller;
import processSale.view.View;
import processSale.integration.RegistryCreator;
import processSale.integration.ItemNotFoundException;
import processSale.integration.DatabaseFailureException;
import processSale.integration.Printer;
import java.lang.String;

public class Main {

	/**
	 * Starts the application.
	 * @param args The application does not take any command line parameters.
	 * @throws ItemNotFoundException if an item with the specified identifier does not exist.
	 * @throws DatabaseFailureException if the database is not reachable.
	 */
	public static void main(String[] args) throws ItemNotFoundException, DatabaseFailureException {
		RegistryCreator creator = new RegistryCreator();

		Printer printer = new Printer();

		Controller contr = new Controller(creator, printer);

		View view = new View(contr);

		view.runProgram();
	}

}
