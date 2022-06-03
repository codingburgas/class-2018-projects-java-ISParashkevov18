package controllers;

import menus.AccMenu;
import menus.Errors;
import services.AuthenticationService;
import utils.ConsoleUtils;

public class AuthenticationController {

	private Errors errorMenu = new Errors();
	private final AuthenticationService authService;

	private static AuthenticationController instance = null;

	public static AuthenticationController getInstance() {

		if (AuthenticationController.instance == null) {
			AuthenticationController.instance = new AuthenticationController();
		}

		return AuthenticationController.instance;
	}

	public AuthenticationController() {
		this.authService = AuthenticationService.getInstance();
	}

	public void run() {

		while (authService.getLoggedUser() == null) {

			// ConsoleUtils.write(AccountMenus.Login());

			ConsoleUtils.writeConsoleLine("USERNAME: ");
			String username = ConsoleUtils.readConsoleLine();

			ConsoleUtils.writeConsoleLine("PASSWORD: ");
			String password = ConsoleUtils.readConsoleLine();

			authService.authenticateUser(username, password);
			// authService.getAdmin(username, password);

			if (authService.getLoggedUser() == null) {
				ConsoleUtils.writeConsoleLine(errorMenu.UnvalidInputError());
			}
		}

	}
}