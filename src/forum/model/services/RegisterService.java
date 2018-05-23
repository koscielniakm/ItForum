package forum.model.services;

import java.util.Date;

import forum.model.dao.DAOUser;
import forum.model.entities.User;
import forum.model.misc.PasswordHasher;

public class RegisterService {

	private RegisterService() { }
	
	private static final int MIN_LOGIN_LENGTH = 5;
	private static final int MAX_LOGIN_LENGTH = 20;
	private static final int MIN_PASSWORD_LENGTH = 8;
	private static final int MAX_PASSWORD_LENGTH = 20;
	
	private static DAOUser userAccess = new DAOUser();
	
	public static RegisterResult register(String login, String password, String password2,  String email) {
		RegisterResult currentResult = correctRegisterData(login, password, password2, email);
		if (currentResult == RegisterResult.SUCCESS){
			createNewUser(login, password, email);
			return RegisterResult.SUCCESS;
		}
		return currentResult;
	}
	private static RegisterResult checkUserExistence(String login, String email) {
		boolean exist =  userAccess.checkUserExistence(login, email);
		if (exist) return RegisterResult.ERROR_USER_EXIST;
		else return RegisterResult.SUCCESS;
	}
	private static RegisterResult correctRegisterData(String login, String password,
		String password2, String email) {
		RegisterResult[] checkResults = new RegisterResult[4];
		checkResults[0] = correctLogin(login);
		checkResults[1] = correctPassword(password, password2);
		checkResults[2] = correctEmail(email);
		checkResults[3] = checkUserExistence(login, email);
		RegisterResult wrong = RegisterResult.ERROR;
		int positiveChecks = 0;
		for (RegisterResult result : checkResults)
			if (result == RegisterResult.SUCCESS)
				positiveChecks += 1;
			else wrong = result;
		if (positiveChecks == checkResults.length) return RegisterResult.SUCCESS;
		else return wrong; /* undefined error */
		
	}
	private static RegisterResult correctLogin(String login) {
		if (login.length() >= MIN_LOGIN_LENGTH &&
			login.length() <= MAX_LOGIN_LENGTH) return RegisterResult.SUCCESS;
		else return RegisterResult.ERROR_WRONG_LOGIN;
	}
	private static RegisterResult correctPassword(String password, String secondPassword) {
		if (!password.equals(secondPassword)) return RegisterResult.ERROR_WRONG_PASSWORD;
		if (password.length() >= MIN_PASSWORD_LENGTH &&
				password.length() <= MAX_PASSWORD_LENGTH) return RegisterResult.SUCCESS;
		else return RegisterResult.ERROR_WRONG_PASSWORD;
	}
	private static RegisterResult correctEmail(String email) {
		/* checking at sign and dot apperance */
		boolean atSignChecked = false;
		boolean dotSignChecked = false;
		int atSignPos = 0;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@' && atSignChecked == false) { 
				atSignChecked = true;
				atSignPos = i;
			}
			/* checking part between @ and . */
			if (atSignChecked && i > atSignPos + 1) {
				if (email.charAt(i) == '.' && i < email.length() - 1)
					dotSignChecked = true;
			}
		}
		if (atSignChecked && dotSignChecked) return RegisterResult.SUCCESS;
		else return RegisterResult.ERROR_WRONG_EMAIL;
	}
	
	private static void createNewUser(String login, String password, String email) {
		User createdUser = new User();
		createdUser.setLogin(login);
		createdUser.setEmail(email);
		createdUser.setPassword(PasswordHasher.hash(password));
		createdUser.setRegisterDate(new Date());
		userAccess.create(createdUser);
	}
	
}
