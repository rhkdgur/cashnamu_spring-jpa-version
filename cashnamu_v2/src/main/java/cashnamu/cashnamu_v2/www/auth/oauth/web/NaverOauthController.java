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

@RestController
public class NaverOauthController extends BaseOauthController{
	
	
	@Resource(name="naverOauthService")
	private Map<String,String> naverOauthService;
	
	@Autowired
	private MemberService memberService;
	
	
	/**
	 * 네이버 로그인 처리
	 * @param state
	 * @param code
	 * @param request
	 * @param reponse
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/oauth/naver/response.do")
	public ResponseEntity<String> oauthResponse(@RequestParam("state") String state,
								@RequestParam(value="code",defaultValue = "") String code,
								HttpServletRequest request,
								HttpServletResponse reponse) throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		
		OauthDetailsDTO oauthDetailsDTO = new OauthDetailsDTO();
		oauthDetailsDTO = createOauthDetail(naverOauthService);
		oauthDetailsDTO.setState(state);
		oauthDetailsDTO.setAuthorizationCode(code);
		
		oauthDetailsDTO = OauthUtil.getAccessToken(oauthDetailsDTO);
		
		JSONObject json = new JSONObject();
		json = OauthUtil.getProfile(oauthDetailsDTO);
		
		if("00".equals(json.get("resultCode").toString())) {
			JSONObject res = (JSONObject) json.get("response");
			if(res.get("email") == null) {
				return new ResponseEntity<String>("네이버 정보를 받아오지 못하였습니다. 다시 진행해주시기 바랍니다.",HttpStatus.NOT_FOUND);
			}
			memberDTO.setId((String)res.get("email"));
			memberDTO.setDkey((String)res.get("id"));
			
			MemberDTO prevVO = memberService.selectMember(memberDTO);
			if(prevVO != null) {
				//회원탈퇴 정보일경우
				if(prevVO.getStatus() == 0) {
					return new ResponseEntity<String>("로그인 불가능한 아이디입니다.",HttpStatus.BAD_REQUEST);
				}
				
				MemberSession.CreateUserSession(request.getSession(),prevVO);
			}else {
				String name = (String)res.get("name");
				if(name == null) {
					name = ((String)res.get("email")).split("@")[0];
				}
				memberDTO.setName(name);
				memberDTO.setGubun(LoginGubunType.NAVER);
				ObjectMapper mapper = new ObjectMapper();
				String map = mapper.writeValueAsString(memberDTO);
				
				//임시 데이터 문자열 전송
				return new ResponseEntity<String>(map.toString(),HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<String>("로그인 되었습니다.",HttpStatus.OK);
	}
	
}
