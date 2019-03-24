package helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class PasswordHelper {
	public static String hashPassword(String password) throws NoSuchAlgorithmException{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] mdArray = md.digest();
			String st = Base64.encode(mdArray);
			return st;
	}
	
	public static String getSalt() {
		Random r = new SecureRandom();
		byte[] saltBytes = new byte[32];
		r.nextBytes(saltBytes);
		String salt = Base64.encode(saltBytes);
		return salt;
	}
}
