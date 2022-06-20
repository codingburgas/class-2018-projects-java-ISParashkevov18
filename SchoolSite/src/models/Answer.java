package models;

import java.util.Objects;

public class Answer {
    private int answerID;
    private String answer;


    // Constructor
    public Answer(int answerID, String answer) {
        this.answerID = answerID;
        this.answer = answer;

    }

    // Getters and Setters

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
    public String toString() {
        return "Answer{" +
                "answerID=" + answerID +
                ", answer='" + answer + '\'' +
                '}';
    }

}
