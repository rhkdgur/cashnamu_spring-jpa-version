package cashnamu.cashnamu_v2.www.auth.oauth;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class OauthDetailsDTO implements Cloneable{
	
	/**시스템 명*/
	private String systemName = "";
	
	/**클라이언트 id*/
	private String clientId= "";
	
	/**비공개 키*/
	private String clientSecret= "";
	
	/**인증 후 돌아 갈 경로*/
	private String redirectUrl = "";
	
	/**상태 토큰*/
	private String authorizationCode = "";
	
	/**접근 토큰*/
	private String accessToken = "";
	
	/**갱신 토큰*/
	private String refreshToken = "";
	
	/**요청 헤더에 포함하는 토큰 타입*/
	private String tokenType = "";
	
	/**유효기간*/
	private String expiresIn = "";
	
	/**인증 요청하는 팝업 url*/
	private String authorizeUrl = "";
	
	/**인증 토큰 가져오는 url*/
	private String tokenUrl = "";
	
	/**기타 접근용 정보 url*/
	private String resourceUrl  ="";
	
	/**프로필 정보 url*/
	private String profileUrl = "";
	
	private String state = "";
	
	/**토큰 아이디 google 용*/
	private String tokenId = "";
	
	/**
	 * sns 서비스 초기값 세팅
	 * @param serviceProperty
	 */
	public OauthDetailsDTO(Map<String,String> serviceProperty) {
		this.systemName = serviceProperty.get("system_name");
		this.clientId = serviceProperty.get("client_id");
		this.clientSecret = serviceProperty.get("client_secret");
		this.redirectUrl = serviceProperty.get("redirect_url");
		this.authorizeUrl = serviceProperty.get("authorize_url");
		this.tokenUrl = serviceProperty.get("token_url");
		this.profileUrl = serviceProperty.get("profile_url");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
