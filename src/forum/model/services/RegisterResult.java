package forum.model.services;

public enum RegisterResult {
	SUCCESS, // correct
	ERROR, // undefined error
	ERROR_USER_EXIST, // user login or email already exist
	ERROR_WRONG_LOGIN, // wrong login length or syntax
	ERROR_WRONG_PASSWORD, // password and second password are different or wrong length 
	ERROR_WRONG_EMAIL // email is not correct
}
