package forum.model.misc;

public class PasswordHasher {
	
	private PasswordHasher() { }
	
	private static String salt = "9231984066775208";
		
	/* simple and basic algorithm of password hash */
	public static String hash(String password) {
		String hashedPassword = password.hashCode() - 20 + salt;
		return hashedPassword;
	}
	
}
