package controllers;

import menus.WelcomeMenu;
import repositories.UserRepository;
import menus.*;
import models.User;

import utils.ConsoleUtils;
import services.AuthenticationService;
import java.util.*;

public class Controller {
	private AuthenticationController authController = new AuthenticationController();

	private AccMenu accMenus = new AccMenu();
	private RegistrationController register = new RegistrationController();
	private WelcomeMenu welcomeMenu = new WelcomeMenu(); 

	private UserRepository repo = new UserRepository();

	private AuthenticationService authService;

	public Controller() {
		this.authService = AuthenticationService.getInstance();
	}

	public void run() {

		String optionForAccount;

		welcomeMenu.MainMenu();

		optionForAccount = ConsoleUtils.readConsoleLine();

		while (Integer.parseInt(optionForAccount) != 1 && Integer.parseInt(optionForAccount) != 2) {

			Errors.UnvalidInputError();

			optionForAccount = ConsoleUtils.readConsoleLine();
		}

		if (Integer.parseInt(optionForAccount) == 1) {

			accMenus.loginMenu();

			authController.run();
			
			if (authService.getLoggedUser()!=null) {
				AdminController adminController = new AdminController();
				adminController.run();
			}else {
				UserController loggedUser = new UserController();
				loggedUser.run();
			}

		} else if (Integer.parseInt(optionForAccount) == 2) {
			accMenus.registerMenu();
			register.run();
		}
	}
}
