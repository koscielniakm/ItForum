package forum.model.services;

import forum.model.dao.DaoUser;
import forum.model.entities.UserEntity;

public class LoginService {

	private DaoUser userAccess;
	
	public LoginService() {
		userAccess = new DaoUser();
	}
	private DaoUser getUserAccess() {
		return userAccess;
	}
	
	public UserEntity login(String loginOrEmail, String password) {
		password = PasswordHasher.hash(password);
		UserEntity loggedUser = getUserAccess().findByLoginAndPassword(loginOrEmail, password); 
		return loggedUser;
	}
	
}
