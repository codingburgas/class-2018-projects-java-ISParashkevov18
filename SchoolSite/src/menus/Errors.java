package menus;

import utils.ConsoleUtils;

public class Errors {

	public static Object UnvalidInputError() {
		ConsoleUtils.writeConsoleLine("------------------------------------------------------");
		ConsoleUtils.writeConsoleLine("|                                                    |");
		ConsoleUtils.writeConsoleLine("|                  Wrong credentials                 |");
		ConsoleUtils.writeConsoleLine("|                  	 Try again!		                |");
		ConsoleUtils.writeConsoleLine("|                                                    |");
		ConsoleUtils.writeConsoleLine("------------------------------------------------------");
		return"";
	}

}
