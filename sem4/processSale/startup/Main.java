package processSale.startup;

import processSale.controller.Controller;
import processSale.view.View;
import processSale.integration.RegistryCreator;
import processSale.integration.ItemNotFoundException;
import processSale.integration.Printer;
import java.lang.String;

public class Main {
	public static void main(String[] args) throws ItemNotFoundException {
		RegistryCreator creator = new RegistryCreator();

		Printer printer = new Printer();

		Controller contr = new Controller(creator, printer);

		View view = new View(contr);

		view.runProgram();
	}

}
