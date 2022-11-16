package cashnamu.cashnamu_v2.www.auth.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.auth.util
* @fileName        : SHA256TypeHandler.java
* @author        : rhkdg
* @description : 비밀번호 암호화 처리
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.17	고광혁			최초생성
 */
public class SHA256TypeHandler{
	
	private static final PasswordEncoder enc = new BCryptPasswordEncoder();
	
	/**
	 * 암호화
	 * @param s
	 * @return
	 */
	public static String encode(String s) {
		return enc.encode(s);
	}
	
	/**
	 * 비밀번호 비교,현재 비밀번호 처리와 이전 사용 암호화 비교
	 * @param password
	 * @param encordpassword
	 * @return
	 */
	public static boolean matches(String password,String encordpassword) {
		return enc.matches(password, encordpassword) || (new OldSHA256().getSHA256(password).equals(encordpassword));
	}

}
