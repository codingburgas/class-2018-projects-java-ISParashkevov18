
package controllers;

import java.util.List;
import java.util.stream.Collectors;

import menus.Errors;
import models.Question;
import services.QuestionServices;
import utils.ConsoleUtils;

public class QuestionController {

	private final QuestionServices questionService;

	String question = null;

	public QuestionController() {
		this.questionService = QuestionServices.getInstance();

	}

	public void viewAllQuestions() {

		System.out.println("-----------------------------------");
		System.out.println("|                                 |");
		System.out.println("|       All uploaded questions    |");
		System.out.println("|                                 |");
		System.out.println("-----------------------------------");

		List<Question> questions = questionService.getAllQuestion();

		System.out.println("Questions and their subjects:");
		ConsoleUtils.writeNewLine();
		questions.stream().forEach(question -> System.out.println(question.getQuestions()));
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

	public void insertQuestion() {

		ConsoleUtils.writeNewLine();

		ConsoleUtils.writeConsoleLine("Subject: ");
		String subject = ConsoleUtils.readConsoleLine();

		ConsoleUtils.writeConsoleLine("Question: ");
		String question = ConsoleUtils.readConsoleLine();

		questionService.insertQuestion(subject, question);

		System.out.println("The question has been added successfully");
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
	
public void deleteQuestionById() {
		
		ConsoleUtils.writeNewLine();
		System.out.println("-----------------------------------");
		System.out.println("|                                 |");
		System.out.println("|       All uploaded questions    |");
		System.out.println("|                                 |");
		System.out.println("-----------------------------------");
		ConsoleUtils.writeNewLine();

		List<Question> questions = questionService.getAllQuestion();
		List<Integer> getAllIds = questions.stream().map(id -> id.getQuestionID()).collect(Collectors.toList());

		ConsoleUtils.writeNewLine();
		questions.stream().forEach(question -> {

			ConsoleUtils.writeConsoleLine("Question ID: ");
			ConsoleUtils.writeInteger(question.getQuestionID());
	
			ConsoleUtils.writeConsoleLine(" | Question: ");
			ConsoleUtils.writeConsoleLine(question.getQuestions());
		});
		ConsoleUtils.writeNewLine();

		ConsoleUtils.writeConsoleLine("Type the id of the question you want to delete: "); int id = ConsoleUtils.readInteger();

		while(!getAllIds.contains(id)) {
			ConsoleUtils.writeNewLine();
			Errors.UnvalidInputError();
			ConsoleUtils.writeConsoleLine("Type the id of the question you want to delete: "); id = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
		}

		questionService.deleteQuestionById(id);

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
