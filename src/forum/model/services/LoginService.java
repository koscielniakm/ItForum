package forum.model.services;

import forum.model.dao.DAOUser;
import forum.model.entities.User;
import forum.model.misc.PasswordHasher;

public class LoginService {

	private LoginService() { }

	private static DAOUser userAccess = new DAOUser();
	
	public static User login(String loginOrEmail, String password) {
		password = PasswordHasher.hash(password);
		User loggedUser = userAccess.findByLoginAndPassword(loginOrEmail, password); 
		return loggedUser;
	}
	
}
