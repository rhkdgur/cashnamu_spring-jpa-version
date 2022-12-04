package cashnamu.cashnamu_v2.www.auth.oauth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import cashnamu.cashnamu_v2.www.common.http.HttpsTransferUtil;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.auth.oauth
* @fileName        : OauthUtil.java
* @author        : rhkdg
* @description : Oauth sns 처리 유틸 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.12.01	고광혁 			최초생성
 */
public class OauthUtil {
	

	/**
	 * 접근 토큰 생성
	 * @param oauthDetail
	 * @return
	 * @throws Exception
	 */
	public static OauthDetailsDTO getAccessToken(OauthDetailsDTO oauthDetail) throws Exception {
		
		List<String> parameter = new ArrayList<>();
		parameter.add("client_id="+oauthDetail.getClientId());
		parameter.add("client_secret="+oauthDetail.getClientSecret());
		parameter.add("grant_type=authorization_code");
		parameter.add("state="+oauthDetail.getState());
		parameter.add("code="+oauthDetail.getAuthorizationCode());
		parameter.add("redirect_uri="+oauthDetail.getRedirectUrl());
		
		String joinParameter = String.join("&", parameter);
		String responseBody = HttpsTransferUtil.post(oauthDetail.getTokenUrl(), joinParameter);
		
		JSONObject json = new JSONObject();
		json = (JSONObject)(new JSONParser()).parse(responseBody);
		
		if("GOOGLE".equals(oauthDetail.getSystemName())) {
			if(json.get("access_token") != null || json.get("refresh_token") != null) {
				oauthDetail.setAccessToken(json.get("access_token").toString());
				oauthDetail.setRefreshToken(json.get("refresh_token").toString());
				oauthDetail.setTokenId(json.get("id_token").toString());
			}
		}else {
			if(json.get("access_token") != null || json.get("refresh_token") != null) {
				oauthDetail.setAccessToken(json.get("access_token").toString());
				
				oauthDetail.setTokenType(json.get("token_type").toString());
				oauthDetail.setExpiresIn(json.get("expires_in").toString());
			}
		}
		
		return oauthDetail;
	}
	
	/**
	 * 토큰 새 생성
	 * @param oauthDetail
	 * @return
	 * @throws Exception
	 */
	public static OauthDetailsDTO getRefreshToken(OauthDetailsDTO oauthDetail) throws Exception {
		
		List<String> parameter = new ArrayList<>();
		parameter.add("client_id="+oauthDetail.getClientId());
		parameter.add("client_secret="+oauthDetail.getClientSecret());
		parameter.add("grant_type=refresh_token");
		parameter.add("refresh_token="+oauthDetail.getRefreshToken());
		parameter.add("redirect_uri="+oauthDetail.getRedirectUrl());
		
		String joinParameter = String.join("&", parameter);
		String responseBody = HttpsTransferUtil.post(oauthDetail.getTokenUrl(), joinParameter);
		
		JSONObject json = new JSONObject();
		json = (JSONObject)(new JSONParser()).parse(responseBody);
		
		if(json.get("access_token") != null) {
			oauthDetail.setAccessToken(json.get("access_token").toString());
			
			oauthDetail.setTokenType(json.get("token_type").toString());
			oauthDetail.setExpiresIn(json.get("expires_in").toString());
		}
		
		return oauthDetail;
	}
	
	/**
	 * 사용자 정보 가져오기
	 * @param oauthDetail
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getProfile(OauthDetailsDTO oauthDetail) throws Exception {
		
		OauthDetailsDTO dto = (OauthDetailsDTO)oauthDetail.clone();
		
		String token = dto.getAccessToken();
		String header = "Bearer "+token;
		
		String apiUrl = dto.getProfileUrl();
		
		Map<String,String> requestHeader = new HashMap<>();
		if(!"GOOGLE".equals(oauthDetail.getSystemName())){
			requestHeader.put("Authorization", header);
		}else {
			token = dto.getTokenId();
			apiUrl += ("?id_token="+token);
		}
		
		String responseBody = HttpsTransferUtil.get(apiUrl, requestHeader);
		
		JSONObject json = new JSONObject();
		json = (JSONObject)(new JSONParser()).parse(responseBody);
		
		return json;
	}

}
