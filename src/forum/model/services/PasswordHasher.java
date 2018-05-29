package forum.model.services;

public class PasswordHasher {
	
	private PasswordHasher() { }
	
	private static String salt = "9231984066775208";
		
	/* simple and basic algorithm of password hash */
	public synchronized static String hash(String password) {
		String hashedPassword = password.hashCode() - 20 + salt;
		return hashedPassword;
	}
	
}
