package forum.model.services.entityservices;

import forum.model.persistence.dao.DaoUser;
import forum.model.persistence.entities.UserEntity;
import forum.model.services.auth.AuthDataValidator;
import forum.model.services.auth.AuthValidationResult;

public class UserManageService {

	private AuthDataValidator validator;
	private DaoUser userAccess;
	
	public UserManageService() {
		userAccess = new DaoUser();
		validator = new AuthDataValidator();
	}
	
	public void insertUser(UserEntity user) {
		userAccess.create(user);
	}
	
	public void updateUser(UserEntity user) {
		userAccess.update(user);
	}
	
	private void deleteUser(Integer userId) {
		userAccess.delete(userId);
	}
	
	public void deleteUser(UserEntity user, String password) {
		if (user.getPassword().equals(password))
			deleteUser(user.getId());
	}
	
	public AuthValidationResult changeEmail(UserEntity user, String email) {
		boolean emailValidation = validator.validateEmail(email);
		if (emailValidation) {
			user.setEmail(email);
			userAccess.update(user);
			return AuthValidationResult.SUCCESS;
		} else {
			return AuthValidationResult.ERROR_WRONG_EMAIL;
		}
	}
	
	public AuthValidationResult changePassword(UserEntity user, String currentPassword, String newPassword, String newPasswordCommit) {
		boolean newPasswordsEquality = validator.comparePasswords(newPassword, newPasswordCommit);
		boolean oldAndNewPasswordsComparation = validator.comparePasswords(newPassword, newPasswordCommit);
		boolean passwordValidation = validator.validatePassword(newPassword);
		if (!newPasswordsEquality) {
			return AuthValidationResult.ERROR_DIFFERENT_PASSWORDS;
		} else if (!passwordValidation) {
			return AuthValidationResult.ERROR_WRONG_PASSWORD_LENGTH;
		} else if (!oldAndNewPasswordsComparation) {
			return AuthValidationResult.ERROR_WRONG_OLDNEW_COMPARATION;
		} else if (oldAndNewPasswordsComparation && newPasswordsEquality && passwordValidation) {
			user.setPassword(newPassword);
			userAccess.update(user);
			return AuthValidationResult.SUCCESS;
		}
		return AuthValidationResult.ERROR;
	}
	
	
}
