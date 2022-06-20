
package controllers;

import java.util.List;
import java.util.stream.Collectors;

import menus.Errors;
import models.Lesson;
import services.LessonServices;
import utils.ConsoleUtils;

public class LessonController {

	private final LessonServices lessonService;

	String lesson = null;

	public LessonController() {
		this.lessonService = LessonServices.getInstance();

	}

	public void viewAllLessons() {

		System.out.println("-----------------------------------");
		System.out.println("|                                 |");
		System.out.println("|       All uploaded lessons      |");
		System.out.println("|                                 |");
		System.out.println("-----------------------------------");

		List<Lesson> lessons = lessonService.getAllLesson();

		System.out.println("Questions and their subjects:");
		ConsoleUtils.writeNewLine();
		lessons.stream().forEach(lesson -> System.out.println(lesson.getLessonName()));
		ConsoleUtils.writeNewLine();

		System.out.println("Press 1 to go back:");
		int option = ConsoleUtils.readInteger();
		System.out.println();

		while (true) {
			switch (option) {
			case 1: {
				backToAdminMenu();
				break;
			}

			default:
				Errors.UnvalidInputError();
				option = ConsoleUtils.readInteger();
			}
		}
	}

	public void insertLesson() {

		ConsoleUtils.writeNewLine();

		ConsoleUtils.writeConsoleLine("Lesson: ");
		String lesson = ConsoleUtils.readConsoleLine();
		lessonService.insertLesson(lesson);

		System.out.println("The Lesson has been added successfully");
		ConsoleUtils.writeConsoleLine("Type 1 to back: ");
		int option = ConsoleUtils.readInteger();

		while (option != 1) {
			Errors.UnvalidInputError();
			ConsoleUtils.writeConsoleLine("Type 1 to back: ");
			option = ConsoleUtils.readInteger();
		}

		backToAdminMenu();
	}

	private void backToAdminMenu() {
		AdminController administrationController = new AdminController();
		administrationController.run();
	}

	
public void deleteLessonById() {
		
		ConsoleUtils.writeNewLine();
		System.out.println("-----------------------------------");
		System.out.println("|                                 |");
		System.out.println("|       All uploaded lessons      |");
		System.out.println("|                                 |");
		System.out.println("-----------------------------------");
		ConsoleUtils.writeNewLine();

		List<Lesson> lessons = lessonService.getAllLesson();
		List<Integer> getAllIds = lessons.stream().map(id -> id.getLessonID()).collect(Collectors.toList());

		ConsoleUtils.writeNewLine();
		lessons.stream().forEach(lesson -> {

			ConsoleUtils.writeConsoleLine(" LessonID: ");
			ConsoleUtils.writeInteger(lesson.getLessonID());
	
			ConsoleUtils.writeConsoleLine(" | Lesson: ");
			ConsoleUtils.writeConsoleLine(lesson.getLessonName());
		});
		ConsoleUtils.writeNewLine();

		ConsoleUtils.writeConsoleLine("Type the id of the lesson you want to delete: "); int id = ConsoleUtils.readInteger();

		while(!getAllIds.contains(id)) {
			ConsoleUtils.writeNewLine();
			Errors.UnvalidInputError();
			ConsoleUtils.writeConsoleLine("Type the id of the lesson you want to delete: "); id = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
		}

		lessonService.deleteLessonById(id);

		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeConsoleLine("Successfully deleted!");
		ConsoleUtils.writeConsoleLine("Type 1 to back: "); int option = ConsoleUtils.readInteger();
		ConsoleUtils.writeNewLine();

		while(option != 1) {
			ConsoleUtils.writeNewLine();
			Errors.UnvalidInputError();
			ConsoleUtils.writeConsoleLine("Type 1 to back: "); option = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
		}

		backToAdminMenu();
	}
}
