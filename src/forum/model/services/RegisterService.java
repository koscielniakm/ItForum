package forum.model.services;

import java.util.Date;

import forum.model.dao.DaoUser;
import forum.model.entities.UserEntity;

public class RegisterService {
	
	private DaoUser userAccess;
	private DataValidator validator; 
	
	public RegisterService() { 
		this.userAccess = new DaoUser();
		this.validator = new DataValidator();
	}
	private DaoUser getUserAccess() {
		return userAccess;
	}
	private DataValidator getValidator() {
		return validator;
	}
	
	public RegisterResult register(String login, String password, String password2,  String email) {
		RegisterResult currentResult = correctRegisterData(login, password, password2, email);
		if (currentResult == RegisterResult.SUCCESS){
			createNewUser(login, password, email);
			return RegisterResult.SUCCESS;
		}
		return currentResult;
	}
	private RegisterResult checkUserExistence(String login, String email) {
		boolean exist =  getUserAccess().checkUserExistence(login, email);
		if (exist) return RegisterResult.ERROR_USER_EXIST;
		else return RegisterResult.SUCCESS;
	}
	private RegisterResult correctRegisterData(String login, String password,
		String password2, String email) {
		RegisterResult[] checkResults = new RegisterResult[4];
		checkResults[0] = correctLogin(login);
		checkResults[1] = comparePasswords(password, password2);
		checkResults[2] = correctPassword(password);
		checkResults[3] = correctEmail(email);
		checkResults[4] = checkUserExistence(login, email);
		RegisterResult wrong = RegisterResult.ERROR;
		int positiveChecks = 0;
		for (RegisterResult result : checkResults)
			if (result == RegisterResult.SUCCESS)
				positiveChecks += 1;
			else wrong = result;
		if (positiveChecks == checkResults.length) return RegisterResult.SUCCESS;
		else return wrong; /* undefined error */
	}
	private RegisterResult correctLogin(String login) {
		if (getValidator().validateLogin(login)) return RegisterResult.SUCCESS;
		else return RegisterResult.ERROR_WRONG_LOGIN;
	}
	private RegisterResult correctPassword(String password) {
		if (getValidator().validatePassword(password)) return RegisterResult.SUCCESS;
		else return RegisterResult.ERROR_WRONG_PASSWORD;
	}
	private RegisterResult comparePasswords(String firstPassword, String secondPassword) {
		if (firstPassword == secondPassword) return RegisterResult.SUCCESS;
		else return RegisterResult.ERROR_DIFFERENT_PASSWORDS;
	}
	private RegisterResult correctEmail(String email) {
		if (getValidator().validatePassword(email)) return RegisterResult.SUCCESS;
		else return RegisterResult.ERROR_WRONG_EMAIL;
	}
	
	private void createNewUser(String login, String password, String email) {
		UserEntity createdUser = new UserEntity();
		createdUser.setLogin(login);
		createdUser.setEmail(email);
		createdUser.setPassword(PasswordHasher.hash(password));
		createdUser.setRegisterDate(new Date());
		userAccess.create(createdUser);
	}
	
}
