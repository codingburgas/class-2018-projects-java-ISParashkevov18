package services;

import java.util.List;

import models.Lesson;
import repositories.AnswerRepository;
import repositories.QuestionRepository;
import repositories.LessonRepository;
import utils.ConsoleUtils;


public class LessonServices {
	
	private static LessonServices instance = null;
	private final LessonRepository lessonRepository;
	
	
	private LessonServices() {
        this.lessonRepository = LessonRepository.getInstance();
	}
		
	public static LessonServices getInstance() {

        if (LessonServices.instance == null) {
        	LessonServices.instance = new LessonServices();
		}

        return LessonServices.instance;
    }
	
	public List<Lesson> getAllLesson() {
		
		List<Lesson> lesson = lessonRepository.getAllLesson();
		return lesson;
	}
	
	public void insertLesson(String lessonName) {
		lessonRepository.insertLesson(lessonName);
	}
	public void deleteLessonById(int lessonID) {
		lessonRepository.deleteLessonById(lessonID);
	}
}