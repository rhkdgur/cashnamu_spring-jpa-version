package cashnamu.cashnamu_v2.www.auth.oauth;

import lombok.Getter;
import lombok.Setter;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.auth.oauth
* @fileName        : OauthDTO.java
* @author        : rhkdg
* @description : Sns 공통 정보 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.12.01	고광혁			ghgo
 */
@Getter @Setter
public class OauthDTO {
	
	/**실명*/
	private String name = "";
	
	/**아이디*/
	private String id = "";
	
	/**이메일*/
	private String email = "";
	
	/**SNS 종류*/
	private String snsType = "";
	
	/***접근토큰*/
	private String accessToken = "";
	
	/**갱신토큰*/
	private String refreshToken = "";
}
