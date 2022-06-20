package services;

import java.util.List;

import models.Answer;
import models.Question;
import repositories.AnswerRepository;
import repositories.QuestionRepository;
import utils.ConsoleUtils;


public class QuestionServices {
	
	private static QuestionServices instance = null;
	private final QuestionRepository questionRepository;
	
	
	private QuestionServices() {
        this.questionRepository = QuestionRepository.getInstance();
	}
		
	public static QuestionServices getInstance() {

        if (QuestionServices.instance == null) {
        	QuestionServices.instance = new QuestionServices();
		}

        return QuestionServices.instance;
    }
	
	public List<Question> getAllQuestion() {
		
		List<Question> question = questionRepository.getAllQuestion();
		return question;
	}

	public void insertQuestion(String subject, String question) {
		questionRepository.insertQuestion(subject, question);
	}
	public void deleteQuestionById(int questionID) {
		questionRepository.deleteQuestionById(questionID);
	}
}