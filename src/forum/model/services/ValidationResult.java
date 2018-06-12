package forum.model.services;

public enum ValidationResult {
	SUCCESS, // correct
	ERROR, // undefined error
	ERROR_USER_EXIST, // user login or email already exist
	ERROR_WRONG_LOGIN, // wrong login length or syntax
	ERROR_WRONG_PASSWORD_LENGTH, // wrong password length
	ERROR_WRONG_OLDNEW_COMPARATION, // old and new passwords are different
	ERROR_DIFFERENT_PASSWORDS, // passwords are different
	ERROR_WRONG_EMAIL // email is not correct
}
