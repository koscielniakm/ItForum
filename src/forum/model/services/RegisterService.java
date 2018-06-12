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
	
	public ValidationResult register(String login, String password, String password2,  String email) {
		ValidationResult currentResult = correctRegisterData(login, password, password2, email);
		if (currentResult == ValidationResult.SUCCESS){
			createNewUser(login, password, email);
			return ValidationResult.SUCCESS;
		}
		return currentResult;
	}
	private ValidationResult checkUserExistence(String login, String email) {
		boolean exist =  getUserAccess().checkUserExistence(login, email);
		if (exist) return ValidationResult.ERROR_USER_EXIST;
		else return ValidationResult.SUCCESS;
	}
	private ValidationResult correctRegisterData(String login, String password,
		String password2, String email) {
		ValidationResult[] checkResults = new ValidationResult[5];
		checkResults[0] = correctLogin(login);
		checkResults[1] = comparePasswords(password, password2);
		checkResults[2] = correctPassword(password);
		checkResults[3] = correctEmail(email);
		checkResults[4] = checkUserExistence(login, email);
		ValidationResult wrong = ValidationResult.ERROR;
		int positiveChecks = 0;
		for (ValidationResult result : checkResults)
			if (result == ValidationResult.SUCCESS)
				positiveChecks += 1;
			else wrong = result;
		if (positiveChecks == checkResults.length) return ValidationResult.SUCCESS;
		else return wrong; /* undefined error */
	}
	private ValidationResult correctLogin(String login) {
		if (getValidator().validateLogin(login)) return ValidationResult.SUCCESS;
		else return ValidationResult.ERROR_WRONG_LOGIN;
	}
	private ValidationResult correctPassword(String password) {
		if (getValidator().validatePassword(password)) return ValidationResult.SUCCESS;
		else return ValidationResult.ERROR_WRONG_PASSWORD_LENGTH;
	}
	private ValidationResult comparePasswords(String firstPassword, String secondPassword) {
		if (firstPassword.equals(secondPassword)) return ValidationResult.SUCCESS;
		else return ValidationResult.ERROR_DIFFERENT_PASSWORDS;
	}
	private ValidationResult correctEmail(String email) {
		if (getValidator().validatePassword(email)) return ValidationResult.SUCCESS;
		else return ValidationResult.ERROR_WRONG_EMAIL;
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
