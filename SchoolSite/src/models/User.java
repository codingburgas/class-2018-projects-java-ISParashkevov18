package models;

import java.util.Objects;

public class User {
    private int userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String userPassword;
    private boolean isTeacher;

    // Constructor
    public User(int userId, String userName, String firstName, String lastName, String email, String userPassword, boolean isTeacher) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userPassword = userPassword;
        this.isTeacher = isTeacher;
    }

    // Getters and Setters
    

	public boolean getIsTeacher() {
		return isTeacher;
	}

	public void setIsTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	@Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + userName + '\'' +
                ", firstname='" + firstName + '\'' +
                ", lastname=" + lastName +
                ", email=" + email +
                ", password=" + userPassword +
                ", teacher=" + isTeacher +
                '}';
    }
}
