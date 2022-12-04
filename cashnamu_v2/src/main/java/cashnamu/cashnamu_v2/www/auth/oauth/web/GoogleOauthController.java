package cashnamu.cashnamu_v2.www.auth.oauth.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import cashnamu.cashnamu_v2.www.auth.oauth.OauthDetailsDTO;
import cashnamu.cashnamu_v2.www.auth.oauth.OauthUtil;
import cashnamu.cashnamu_v2.www.modules.member.MemberSession;
import cashnamu.cashnamu_v2.www.modules.member.dto.MemberDTO;
import cashnamu.cashnamu_v2.www.modules.member.service.LoginGubunType;
import cashnamu.cashnamu_v2.www.modules.member.service.MemberService;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.auth.oauth.web
* @fileName        : GoogleOauthController.java
* @author        : rhkdg
* @description :  구글 로그인 컨트롤러
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.12.02	고광혁			최초생성
 */
@RestController
public class GoogleOauthController extends BaseOauthController{

	@Resource(name="googleOauthService")
	private Map<String,String> googleOauthService;
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/oauth/google/response.do")
	public ResponseEntity<String> oauthResponse(@RequestParam("state") String state,
												@RequestParam(value="code",defaultValue = "") String code,
												HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		MemberDTO memberDTO = new MemberDTO();
		
		OauthDetailsDTO oauthDetailsDTO = new OauthDetailsDTO();
		oauthDetailsDTO = createOauthDetail(googleOauthService);
		oauthDetailsDTO.setState(state);
		oauthDetailsDTO.setAuthorizationCode(code);
		
		oauthDetailsDTO = OauthUtil.getAccessToken(oauthDetailsDTO);
		
		JSONObject json = new JSONObject();
		json = OauthUtil.getProfile(oauthDetailsDTO);
		
		if(json.get("email") == null) {
			return new ResponseEntity<String>("구글 정보를 받아오지 못하였습니다. 다시 진행해주시기 바랍니다.",HttpStatus.NOT_FOUND);
		}
		
		memberDTO.setId((String)json.get("email"));
		memberDTO.setDkey((String)json.get("id"));
		MemberDTO prevVO = memberService.selectMember(memberDTO);
		
		if(prevVO != null) {
			if(prevVO.getStatus() == 0) {
				return new ResponseEntity<String>("로그인 불가능한 아이디입니다.",HttpStatus.BAD_REQUEST);
			}
			
			MemberSession.CreateUserSession(request.getSession(), prevVO);
		}else {
			String name = (String)json.get("name");
			if(name == null) {
				name = ((String)json.get("email")).split("@")[0];
			}
			memberDTO.setName(name);
			memberDTO.setGubun(LoginGubunType.GOOGLE);
			
			ObjectMapper mapper = new ObjectMapper();
			String map = mapper.writeValueAsString(memberDTO);
			
			//임시 데이터 문자열 전송
			return new ResponseEntity<String>(map.toString(),HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("로그인 되었습니다.",HttpStatus.OK);
	}
}
