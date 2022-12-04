package cashnamu.cashnamu_v2.www.auth.oauth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.auth.oauth
* @fileName        : OuathBean.java
* @author        : rhkdg
* @description : sns 로그인 oauth bean 등록
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.12.01	고광혁			최초생성
 */
@Configuration
public class OuathBean {
	

	/**
	 * 네이버 서비스 bean
	 * @return
	 */
	@Bean(name="naverOauthService")
	public Map<String,String> naverOauthService(){
		Map<String,String> map = new HashMap<>();
		map.put("system_name", "NAVER");
		map.put("client_id","wQcPf6OgLjLAx9XnZqgn");
		map.put("client_secret", "11juWcaJFZ");
		map.put("redirect_url", "http://localhost:8181/oauth/naver/response.do");
		map.put("authorize_url", "https://nid.naver.com/oauth2.0/authorize");
		map.put("token_url", "https://nid.naver.com/oauth2.0/token");
		map.put("profile_url", "https://openapi.naver.com/v1/nid/me");
		return map;
	}
	
	/**
	 * 카카오 서비스 bean
	 * @return
	 */
	@Bean(name="kakaoOauthService")
	public Map<String,String> kakaoOauthService(){
		Map<String,String> map = new HashMap<>();
		map.put("system_name", "KAKAO");
		map.put("client_id","aaaa168488baf4dfcaf11643adaca1c8");
		map.put("client_secret", "");
		map.put("redirect_url", "http://localhost:8181/oauth/kakao/response.do");
		map.put("authorize_url", "https://kauth.kakao.com/oauth/authorize");
		map.put("token_url", "https://kauth.kakao.com/oauth/token");
		map.put("profile_url", "https://kapi.kakao.com/v2/user/me");
		return map;
	}
	
	/**
	 * 구글 서비스 bean
	 * @return
	 */
	@Bean(name="googleOauthService")
	public Map<String,String> googleOauthService(){
		Map<String,String> map = new HashMap<>();
		map.put("system_name", "GOOGLE");
		map.put("client_id","737060033536-hr9i8tjnes87nr4v5nlhlrpq6264ob1u.apps.googleusercontent.com");
		map.put("client_secret", "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");
		map.put("redirect_url", "http://localhost:8181/oauth/google/response.do");
		map.put("authorize_url", "https://accounts.google.com/o/oauth2/auth");
		map.put("token_url", "https://oauth2.googleapis.com/token");
		map.put("profile_url", "https://oauth2.googleapis.com/tokeninfo");
		return map;
	}
}
