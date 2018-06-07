package forum.model.services;

public class DataValidator {
	
	private static final int MIN_LOGIN_LENGTH = 5;
	private static final int MAX_LOGIN_LENGTH = 20;
	private static final int MIN_PASSWORD_LENGTH = 8;
	private static final int MAX_PASSWORD_LENGTH = 20;
	
	public boolean validateEmail(String email) {
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
		if (atSignChecked && dotSignChecked) return true;
		else return false;
	}
	
	public boolean validateLogin(String login) {
		if (login.length() >= MIN_LOGIN_LENGTH &&
				login.length() <= MAX_LOGIN_LENGTH) return true;
		else return false;
	}
	
	public boolean validatePassword(String password) {
		if (password.length() >= MIN_PASSWORD_LENGTH &&
				password.length() <= MAX_PASSWORD_LENGTH) return true;
		else return false;
	}
	public boolean comparePasswords(String firstPassword, String secondPassword) {
		//if (firstPassword.equals(secondPassword)) return true;
		//else return false;
		return true;
	}
	
}
