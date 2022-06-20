package controllers;

import utils.ConsoleUtils;
import services.RegisterService;
import menus.Errors;

public class RegistrationController {
	
	UserController loggedUserController = new UserController();
	
	private final RegisterService regService;
	
	public RegistrationController() {
        this.regService = RegisterService.getInstance();
    }
	
	public void run(){
		
		if(regService.getCorrectUser() == false) {
	        
	        ConsoleUtils.writeConsoleLine("USERNAME: ");
	        String username = ConsoleUtils.readConsoleLine();
	        
			ConsoleUtils.writeConsoleLine("FIRST NAME: ");
	        String firstName = ConsoleUtils.readConsoleLine();
	
	        ConsoleUtils.writeConsoleLine("LAST NAME: ");
	        String lastName = ConsoleUtils.readConsoleLine();
	        
	        ConsoleUtils.writeConsoleLine("E-MAIL: ");
	        String email = ConsoleUtils.readConsoleLine();

	        ConsoleUtils.writeConsoleLine("PASSWORD: ");
	        String password = ConsoleUtils.readConsoleLine();
	        
	        regService.insertUser(username, firstName, lastName, email, password);   
		}
		
		ConsoleUtils.writeConsoleLine("Successful registration!");
		ConsoleUtils.writeConsoleLine("Type 1 to back: "); int option = ConsoleUtils.readInteger();
		
		while(true) {
			switch (option) {
				case 1: {
					backToMainMenu();
					break;
				}
				default:
					Errors.UnvalidInputError(); option = ConsoleUtils.readInteger();
			}
		}
	}
	
	private void backToMainMenu() {
		Controller mainMenu = new Controller();
		mainMenu.run();
    }
}