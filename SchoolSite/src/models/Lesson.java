package models;

import java.util.Objects;

public class Lesson {
    private int lessonID;
    private String lessonName;


    // Constructor
    public Lesson(int lessonID, String lessonName) {
        this.lessonID = lessonID;
        this.lessonName = lessonName;

    }

    // Getters and Setters

	public int getLessonID() {
		return lessonID;
	}

	public void setLessonID(int lessonID) {
		this.lessonID = lessonID;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	@Override
    public String toString() {
        return "Question{" +
                "lessonID=" + lessonID +
                ", lessonName='" + lessonName + '\'' +
                '}';
    }


}
