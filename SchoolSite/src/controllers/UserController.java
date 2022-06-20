package controllers;

import services.AuthenticationService;
import menus.AdministrationMenu;
import utils.ConsoleUtils;
import menus.UserMenu;

public class UserController {
	UserMenu UserMenus = new UserMenu();
	private final AuthenticationService authenticationService;

	public UserController() {
		this.authenticationService = AuthenticationService.getInstance();

	}

	public void run() {

		UserMenus.UserMenu();
		int choice = ConsoleUtils.readInteger();
		switch (choice) {
		case 1:
			insertQuestion();
			break;
		case 2:
			viewAllQuestions();
			break;
		case 3:
			insertLesson();
			break;
		case 4:
			viewAllLessons();
			break;
		case 5:
			authenticationService.logClear();
			backToMainMenu();
			break;
		case 6:
			break;
		case 7:

			break;
		}
	}

	public void backToMainMenu() {
		Controller mainController = new Controller();
		mainController.run();
	}

	private void viewAllQuestions() {
		QuestionController question = new QuestionController();
		question.viewAllQuestions();
	}

	private void insertQuestion() {
		QuestionController insertQuestion = new QuestionController();
		insertQuestion.insertQuestion();
	}


	private void viewAllLessons() {
		LessonController viewLessons = new LessonController();
		viewLessons.viewAllLessons();
	}

	private void insertLesson() {
		LessonController insertLessons = new LessonController();
		insertLessons.insertLesson();
	}

}
