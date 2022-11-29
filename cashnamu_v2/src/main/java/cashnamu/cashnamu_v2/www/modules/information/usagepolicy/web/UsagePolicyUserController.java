package cashnamu.cashnamu_v2.www.modules.information.usagepolicy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cashnamu.cashnamu_v2.www.modules.information.usagepolicy.dto.UsagePolicyDTO;
import cashnamu.cashnamu_v2.www.modules.information.usagepolicy.service.UsagePolicyService;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.modules.information.usagepolicy.web
* @fileName        : UsagePolicyUserController.java
* @author        : rhkdg
* @description :  사용자 페이지 이용약관,개인정보
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.29	고광혁		최초생성
 */
@RestController
@Lazy(true)
public class UsagePolicyUserController {

	@Autowired
	private UsagePolicyService usagePolicyService;
	
	
	/**
	 * 이용약관 조회
	 * @param usagePolicyDTO
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/usage")
	public UsagePolicyDTO selectUsage(UsagePolicyDTO usagePolicyDTO) throws Exception{
		return usagePolicyService.selectUsage();
	}
	
	/**
	 * 개인정보 처리 조회
	 * @param usagePolicyDTO
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/policy")
	public UsagePolicyDTO selectPolicy(UsagePolicyDTO usagePolicyDTO) throws Exception{
		return usagePolicyService.selectPolicy();
	}
}
