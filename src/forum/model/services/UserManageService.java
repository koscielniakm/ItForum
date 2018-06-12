package forum.model.services;

import forum.model.dao.DaoUser;
import forum.model.entities.UserEntity;

public class UserManageService {

	private DataValidator validator;
	private DaoUser userAccess;
	
	public UserManageService() {
		userAccess = new DaoUser();
		validator = new DataValidator();
	}
	
	public void insertUser(UserEntity user) {
		userAccess.create(user);
	}
	
	public void updateUser(UserEntity user) {
		userAccess.update(user);
	}
	
	public void deleteUser(Integer userId) {
		userAccess.delete(userId);
	}
	
	public ValidationResult changeEmail(UserEntity user, String email) {
		boolean emailValidation = validator.validateEmail(email);
		if (emailValidation) {
			user.setEmail(email);
			userAccess.update(user);
			return ValidationResult.SUCCESS;
		} else {
			return ValidationResult.ERROR_WRONG_EMAIL;
		}
	}
	
	public ValidationResult changePassword(UserEntity user, String currentPassword, String newPassword, String newPasswordCommit) {
		boolean newPasswordsEquality = validator.comparePasswords(newPassword, newPasswordCommit);
		boolean oldAndNewPasswordsComparation = validator.comparePasswords(newPassword, newPasswordCommit);
		boolean passwordValidation = validator.validatePassword(newPassword);
		if (!newPasswordsEquality) {
			return ValidationResult.ERROR_DIFFERENT_PASSWORDS;
		} else if (!passwordValidation) {
			return ValidationResult.ERROR_WRONG_PASSWORD_LENGTH;
		} else if (!oldAndNewPasswordsComparation) {
			return ValidationResult.ERROR_WRONG_OLDNEW_COMPARATION;
		} else if (oldAndNewPasswordsComparation && newPasswordsEquality && passwordValidation) {
			user.setPassword(newPassword);
			userAccess.update(user);
			return ValidationResult.SUCCESS;
		}
		return ValidationResult.ERROR;
	}
	
	
}
