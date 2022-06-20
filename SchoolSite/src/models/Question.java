package models;

import java.util.Objects;

public class Question {
    private int questionID;
    private String subject;
    private String questions;


    // Constructor
    public Question(int questionID,String subject, String questions) {
        this.questionID = questionID;
        this.subject = subject;
        this.questions = questions;
    }

    // Getters and Setters

    public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}



	@Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", subject='" + subject + '\'' +
                ", questions='" + questions + '\'' +
                '}';
    }

	
}
