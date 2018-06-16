package forum.model.services.auth;

import java.util.Date;

import forum.model.persistence.dao.DaoUser;
import forum.model.persistence.entities.UserEntity;

public class RegisterService {
	
	private DaoUser userAccess;
	private AuthDataValidator validator; 
	
	public RegisterService() { 
		this.userAccess = new DaoUser();
		this.validator = new AuthDataValidator();
	}
	private DaoUser getUserAccess() {
		return userAccess;
	}
	private AuthDataValidator getValidator() {
		return validator;
	}
	
	public AuthValidationResult register(String login, String password, String password2,  String email) {
		AuthValidationResult currentResult = correctRegisterData(login, password, password2, email);
		if (currentResult == AuthValidationResult.SUCCESS){
			createNewUser(login, password, email);
			return AuthValidationResult.SUCCESS;
		}
		return currentResult;
	}
	private AuthValidationResult checkUserExistence(String login, String email) {
		boolean exist =  getUserAccess().checkUserExistence(login, email);
		if (exist) return AuthValidationResult.ERROR_USER_EXIST;
		else return AuthValidationResult.SUCCESS;
	}
	private AuthValidationResult correctRegisterData(String login, String password,
		String password2, String email) {
		AuthValidationResult[] checkResults = new AuthValidationResult[5];
		checkResults[0] = correctLogin(login);
		checkResults[1] = comparePasswords(password, password2);
		checkResults[2] = correctPassword(password);
		checkResults[3] = correctEmail(email);
		checkResults[4] = checkUserExistence(login, email);
		AuthValidationResult wrong = AuthValidationResult.ERROR;
		int positiveChecks = 0;
		for (AuthValidationResult result : checkResults)
			if (result == AuthValidationResult.SUCCESS)
				positiveChecks += 1;
			else wrong = result;
		if (positiveChecks == checkResults.length) return AuthValidationResult.SUCCESS;
		else return wrong; /* undefined error */
	}
	private AuthValidationResult correctLogin(String login) {
		if (getValidator().validateLogin(login)) return AuthValidationResult.SUCCESS;
		else return AuthValidationResult.ERROR_WRONG_LOGIN;
	}
	private AuthValidationResult correctPassword(String password) {
		if (getValidator().validatePassword(password)) return AuthValidationResult.SUCCESS;
		else return AuthValidationResult.ERROR_WRONG_PASSWORD_LENGTH;
	}
	private AuthValidationResult comparePasswords(String firstPassword, String secondPassword) {
		if (firstPassword.equals(secondPassword)) return AuthValidationResult.SUCCESS;
		else return AuthValidationResult.ERROR_DIFFERENT_PASSWORDS;
	}
	private AuthValidationResult correctEmail(String email) {
		if (getValidator().validatePassword(email)) return AuthValidationResult.SUCCESS;
		else return AuthValidationResult.ERROR_WRONG_EMAIL;
	}
	
	private void createNewUser(String login, String password, String email) {
		UserEntity createdUser = new UserEntity();
		createdUser.setLogin(login);
		createdUser.setEmail(email.toLowerCase());
		createdUser.setPassword(PasswordHasher.hash(password));
		createdUser.setRegisterDate(new Date());
		userAccess.create(createdUser);
	}
	
}
