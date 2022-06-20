package services;

import repositories.UserRepository;

public class RegisterService {
	
	private final UserRepository usersRepository;
	private static RegisterService instance = null;
	private boolean correctUser;
	
	private RegisterService() {
        this.usersRepository = UserRepository.getInstance();
    }
	
	public static RegisterService getInstance() {

        if (RegisterService.instance == null) {
        	RegisterService.instance = new RegisterService();
		}

        return RegisterService.instance;
    }
	
	public boolean getCorrectUser() {
        return correctUser;
    }

	public void insertUser( String username, String firstName, String lastName, String email, String password) {
		
		correctUser = usersRepository.insertUser(username, firstName, lastName, email,  password, false);
	}
}
