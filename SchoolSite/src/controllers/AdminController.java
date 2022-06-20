package controllers;

import services.AuthenticationService;
import menus.AdministrationMenu;
import utils.ConsoleUtils;

public class AdminController {

	AdministrationMenu adminMenu = new AdministrationMenu();

	private final AuthenticationService authenticationService;

	public AdminController() {
		this.authenticationService = AuthenticationService.getInstance();

	}

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
			viewAllQuestions();
			break;
		case 5:
			insertQuestion();
			break;
		case 6:
			deleteQuestionById();
			break;
		case 7:
			viewAllLessons();
			break;
		case 8:
			insertLesson();
			break;
		case 9:
			deleteLessonById();
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			authenticationService.logClear();
			backToMainMenu();
			break;

		}
	}

	private void viewAllQuestions() {
		QuestionController question = new QuestionController();
		question.viewAllQuestions();
	}

	public void backToMainMenu() {
		Controller mainController = new Controller();
		mainController.run();
	}

	private void insertQuestion() {
		QuestionController insertQuestion = new QuestionController();
		insertQuestion.insertQuestion();
	}
	private void deleteQuestionById(){
		QuestionController deleteQuestion = new QuestionController();
		deleteQuestion.deleteQuestionById();
	}
	private void viewAllLessons() {
		LessonController viewLessons = new LessonController();
		viewLessons.viewAllLessons();
	}
	private void insertLesson() {
		LessonController insertLessons = new LessonController();
		insertLessons.insertLesson();
	}
	private void deleteLessonById(){
		LessonController deleteLessonById = new LessonController();
		deleteLessonById.deleteLessonById();
	}
}