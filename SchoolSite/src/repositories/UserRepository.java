package repositories;

import models.User;
import services.AuthenticationService;
import utils.ApplicationProperties;
import utils.DataBaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	private static UserRepository instance = null;

	public static UserRepository getInstance() {

		if (UserRepository.instance == null) {
			UserRepository.instance = new UserRepository();
		}

		return UserRepository.instance;
	}

	public List<User> getAllUsers() {
		List<User> listOfUsers = new ArrayList<>();
		String query = "SELECT * FROM Users;";
		try (Connection conn = DataBaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
				ResultSet resultSet = ps.executeQuery();
				
			while (resultSet.next()) {
				User user = mapToUser(resultSet);
				listOfUsers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfUsers;
	}

	public User getRegisteredUser(String userName, String userPassword) {
		User user = null;
		String query = "SELECT * FROM Users WHERE userName = ? AND userPassword = ?;";
		try (Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL);
				PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, userName);
			ps.setString(2, userPassword);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				user = mapToUser(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean getAdminUser(String userName, String userPassword) {
		String query = "SELECT * FROM users WHERE Username = ? AND Password = ?;";
		try (Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL);
				PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, userName);
			ps.setString(2, userPassword);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getInt("Admin") == 0) {
					return false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean insertUser(String userName, String firstName, String lastName, String email, String userPassword,
			boolean teacher) {
		String query1 = "INSERT INTO users (userName, firstName, lastName, email, userPassword, isTeacher) VALUES (?, ?, ?, ?, ?,?)";
		try (Connection conn = DriverManager.getConnection(ApplicationProperties.JDBC_URL);
				PreparedStatement pst = conn.prepareStatement(query1)) {
			pst.setString(1, userName);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, email);
			pst.setString(5, userPassword);
			pst.setBoolean(6, teacher);

			int rs = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	public void deleteUserById(int userId) {
		String query1 = "DELETE FROM Users WHERE userId = ?";
		try (Connection conn = DataBaseConnection.getConnection();
			PreparedStatement pst1 = conn.prepareStatement(query1)) {
	
			pst1.setInt(1, userId);
	
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private User mapToUser(ResultSet resultSet) throws SQLException {
		int userId = resultSet.getInt("userID");
		String firstName = resultSet.getString("firstName");
		String lastName = resultSet.getString("lastName");
		String userName = resultSet.getString("userName");
		String email = resultSet.getString("email");
		String userPassword = resultSet.getString("userPassword");
		boolean isTeacher = resultSet.getBoolean("isTeacher");
		User user = new User(userId, userName, firstName, lastName, email, userPassword, isTeacher);
		return user;
	}
}