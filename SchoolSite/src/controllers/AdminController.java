
package controllers;
import menus.Errors;

import menus.AdministrationMenu;
import utils.ConsoleUtils;
import utils.ConsoleUtils;
public class AdminController {
	
	AdministrationMenu adminMenu = new AdministrationMenu();
	
	public void run() {
		
		adminMenu.AdministrationMenu();
		int choice = ConsoleUtils.readInteger();
		switch (choice) {
		  case 1:
		    break;
		  case 2:
		    break;
		  case 3:
		    break;
		  case 4:
		    break;
		  case 5:
		    break;
		  case 6:
		    break;
		  case 7:;
		    break;
		}
	}

}