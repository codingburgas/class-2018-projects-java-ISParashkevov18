package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Answer;
import models.Lesson;
import utils.DataBaseConnection;

public class LessonRepository {
	
	private static LessonRepository instance = null;

	public static LessonRepository getInstance() {

		if (LessonRepository.instance == null) {
			LessonRepository.instance = new LessonRepository();
		}

		return LessonRepository.instance;
	}
	
	public List<Lesson> getAllLesson() {
		List<Lesson> listOfLesson = new ArrayList<>();
		String query = "SELECT * FROM Lessons;";
		try (Connection conn = DataBaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				Lesson lesson = mapToLesson(resultSet);
				listOfLesson.add(lesson);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfLesson;
	}
	
	public void insertLesson(String lessonName) {
		String query1 = "INSERT INTO Lessons (lessonName) VALUES (?)";
		try (Connection conn = DataBaseConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			
			pst1.setString(1, lessonName);
							
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Lesson mapToLesson(ResultSet resultSet) throws SQLException {
		int lessonID = resultSet.getInt("lessonID");
		String lessonName = resultSet.getString("lessonName");
		Lesson lesson = new Lesson(lessonID,lessonName);
		return lesson;
	}
	public void deleteLessonById(int lessonID) {
		String query1 = "DELETE FROM Lessons WHERE lessonID = ?";
		try (Connection conn = DataBaseConnection.getConnection();
			PreparedStatement pst1 = conn.prepareStatement(query1)) {
	
			pst1.setInt(1, lessonID);
	
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}