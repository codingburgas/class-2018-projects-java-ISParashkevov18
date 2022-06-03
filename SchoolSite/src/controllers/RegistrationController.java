package controllers;

import menus.AccMenu;
import utils.ConsoleUtils;
import repositories.*;
import services.RegisterService;

public class RegistrationController {
	public void run() {
		UserRepository logic = new UserRepository();
		int teacher = 0;

		ConsoleUtils.writeConsoleLine("USERNAME: ");
		String username = ConsoleUtils.readConsoleLine();

		ConsoleUtils.writeConsoleLine("FIRST NAME: ");
		String firstName = ConsoleUtils.readConsoleLine();

		ConsoleUtils.writeConsoleLine("LAST NAME: ");
		String lastName = ConsoleUtils.readConsoleLine();

		ConsoleUtils.writeConsoleLine("EMAIL: ");
		String email = ConsoleUtils.readConsoleLine();

		ConsoleUtils.writeConsoleLine("PASSWORD: ");
		String password = ConsoleUtils.readConsoleLine();

		logic.insertUser(username, firstName, lastName, email, password, teacher);
	}
}