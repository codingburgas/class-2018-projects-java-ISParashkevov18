package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Answer;
import utils.DataBaseConnection;

public class AnswerRepository {
	
	private static AnswerRepository instance = null;

	public static AnswerRepository getInstance() {

		if (AnswerRepository.instance == null) {
			AnswerRepository.instance = new AnswerRepository();
		}

		return AnswerRepository.instance;
	}
	
	public List<Answer> getAllAnswers() {
		List<Answer> listOfAnswers = new ArrayList<>();
		String query = "SELECT * FROM Answers;";
		try (Connection conn = DataBaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				Answer answer = mapToAnswer(resultSet);
				listOfAnswers.add(answer);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfAnswers;
	}
	
	private Answer mapToAnswer(ResultSet resultSet) throws SQLException {
		int answerID = resultSet.getInt("answerID");
		String Answer = resultSet.getString("Answer");
		Answer answer = new Answer(answerID, Answer);
		return answer;
	}
	
	public void insertAnswer(String answer) {
		String query1 = "INSERT INTO Answers (Answer) VALUES (?)";
		try (Connection conn = DataBaseConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			
			pst1.setString(1, answer);
							
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}