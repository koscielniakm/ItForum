package forum.model.services.auth;

import forum.model.persistence.dao.DaoUser;
import forum.model.persistence.entities.UserEntity;

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
