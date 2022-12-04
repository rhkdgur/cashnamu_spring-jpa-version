package cashnamu.cashnamu_v2.www.auth.oauth.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.auth.oauth.web
* @fileName        : OauthController.java
* @author        : rhkdg
* @description : 로그인 페이지 컨트롤러 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.12.01	고광혁			최초생성
 */
@RestController
public class OauthController extends BaseOauthController{

	@Resource(name="naverOauthService")
	private Map<String,String> naverOauthService;
	
	@Resource(name="kakaoOauthService")
	private Map<String,String> kakaoOauthService;
	
	@Resource(name="googleOauthService")
	private Map<String,String> googleOauthService;
	
	
	@GetMapping("/api/oauth/login")
	public Map<String,Object> oauthRequest() throws Exception{
		
		Map<String,Object> map = new HashMap<>();
		map.put("naver", createOauthDetail(naverOauthService));
		map.put("kakao", createOauthDetail(kakaoOauthService));
		map.put("google", createOauthDetail(googleOauthService));
		
		return map;
	}
}
