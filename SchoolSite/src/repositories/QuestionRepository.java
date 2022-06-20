package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Question;
import utils.DataBaseConnection;

public class QuestionRepository {
	
	private static QuestionRepository instance = null;

	public static QuestionRepository getInstance() {

		if (QuestionRepository.instance == null) {
			QuestionRepository.instance = new QuestionRepository();
		}

		return QuestionRepository.instance;
	}
	
	public List<Question> getAllQuestion() {
		List<Question> listOfQuestion = new ArrayList<>();
		String query = "SELECT * FROM Questions;";
		try (Connection conn = DataBaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				Question question = mapToQuestion(resultSet);
				listOfQuestion.add(question);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfQuestion;
	}
	
	private Question mapToQuestion(ResultSet resultSet) throws SQLException {
		int questionID = resultSet.getInt("questionID");
		String subject = resultSet.getString("subject");
		String questions = resultSet.getString("questions");
		Question question = new Question(questionID,subject,questions);
		return question;
	}
	
	public void insertQuestion(String subject, String question) {
		String query1 = "INSERT INTO Questions (subject, questions) VALUES (?,?)";
		try (Connection conn = DataBaseConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			pst1.setString(1, subject);
			pst1.setString(2, question);
							
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteQuestionById(int questionsID) {
		String query1 = "DELETE FROM Questions WHERE questionID = ?";
		try (Connection conn = DataBaseConnection.getConnection();
			PreparedStatement pst1 = conn.prepareStatement(query1)) {
	
			pst1.setInt(1, questionsID);
	
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}