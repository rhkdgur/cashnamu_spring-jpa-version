package cashnamu.cashnamu_v2.www.auth.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class OldSHA256 {
	
		public String getSHA256(String key) {
			StringBuffer result = new StringBuffer();
			
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] salt = "CashTree".getBytes(StandardCharsets.UTF_8);
				digest.reset();
				digest.update(salt);
				byte[] chars = digest.digest(key.getBytes("UTF-8"));
				for(int i = 0; i<chars.length; i++)
				{
					String hex = Integer.toHexString(0xff & chars[i]);
					if(hex.length() < 2)
						result.append("0");
					
					result.append(hex);
				}
			}catch(Exception e) {
				result = null;
			}
			
			return result.toString();
		}


}
