package forum.model.services.account;

import forum.model.dao.DAOUser;
import forum.model.entities.User;

public class LoginService {

	private DAOUser userAccess;
	
	public LoginService() {
		userAccess = new DAOUser();
	}
	private DAOUser getUserAccess() {
		return userAccess;
	}
	
	public User login(String loginOrEmail, String password) {
		password = PasswordHasher.hash(password);
		User loggedUser = getUserAccess().findByLoginAndPassword(loginOrEmail, password); 
		return loggedUser;
	}
	
}
