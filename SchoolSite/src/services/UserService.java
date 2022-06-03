package services;

import java.util.List;
import java.util.stream.Collectors;

import repositories.UserRepository;
import models.User;
/*
    Layer #2: Business Logic
*/
public class UserService {
    
    private final UserRepository usersRepository;
    private static UserService instace = null;
    
    public static UserService getInstance() {
        if (UserService.instace == null) {

        	UserService.instace = new UserService();
        }
        return UserService.instace;
    }
    
		
    public UserService() {
        this.usersRepository = UserRepository.getInstance();
    }

    public List<User> getRegisteredUser(String userName, String userPassword) {
		List<User> users = usersRepository.getRegisteredUser(userName, userPassword);
		
		if(users.isEmpty()) {
			return null;
		} 

		return users;
	}

	public boolean getAdminUser(String userName, String userPassword) {
		
		boolean adminUser = usersRepository.getAdminUser(userName, userPassword);
		if(adminUser == false) {
			return false;
		}
		return true;
	}
    
}