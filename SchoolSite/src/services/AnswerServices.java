package services;

import java.util.List;

import models.Answer;
import models.Question;
import repositories.AnswerRepository;
import repositories.QuestionRepository;
import utils.ConsoleUtils;


public class AnswerServices {
	
	private static AnswerServices instance = null;
	private final AnswerRepository answerRepository;
	
	
	private AnswerServices() {
        this.answerRepository = AnswerRepository.getInstance();
	}
		
	public static AnswerServices getInstance() {

        if (AnswerServices.instance == null) {
        	AnswerServices.instance = new AnswerServices();
		}

        return AnswerServices.instance;
    }
	
	public List<Answer> getAllAnswer() {
		
		List<Answer> answer = answerRepository.getAllAnswers();
		return answer;
	}
	
	public void insertAnswer(String Answer) {
		answerRepository.insertAnswer(Answer);
	}
	
}