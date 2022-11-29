package cashnamu.cashnamu_v2.www.modules.information.usagepolicy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import cashnamu.cashnamu_v2.www.BaseController;
import cashnamu.cashnamu_v2.www.ResponseResultType;
import cashnamu.cashnamu_v2.www.modules.information.usagepolicy.dto.UsagePolicyDTO;
import cashnamu.cashnamu_v2.www.modules.information.usagepolicy.service.UsagePolicyService;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.modules.information.usagepolicy.web
* @fileName        : UsagePolicyController.java
* @author        : rhkdg
* @description : 이용약관,개인정보
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.29	고광혁			최초생성
 */
@RestController
@Lazy(true)
public class UsagePolicyController extends BaseController{

	@Autowired
	private UsagePolicyService usagePolicyService;
	
	/**
	 * 이용약관 조회
	 * @param usagePolicyDTO
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/usage")
	public UsagePolicyDTO selectUsage(UsagePolicyDTO usagePolicyDTO) throws Exception{
		return usagePolicyService.selectUsage();
	}
	
	/**
	 * 개인정보 처리 조회
	 * @param usagePolicyDTO
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/policy")
	public UsagePolicyDTO selectPolicy(UsagePolicyDTO usagePolicyDTO) throws Exception{
		return usagePolicyService.selectPolicy();
	}
	
	/**
	 * 등록,수정
	 * @param usagePolicyDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/usage/act/ins")
	public ResponseEntity<String> saveUsagePolicy(UsagePolicyDTO usagePolicyDTO,SessionStatus status) throws Exception{
		
		try {
			usagePolicyService.saveUsagePolicy(usagePolicyDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.INS_FAIL.name(),HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.INS_SUCCESS.name(),HttpStatus.OK);
	}
	
	/**
	 * 삭제
	 * @param usagePolicyDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/usage/act/del")
	public ResponseEntity<String> deleteUsagePolicy(UsagePolicyDTO usagePolicyDTO,SessionStatus status) throws Exception{
		
		try {
			usagePolicyService.deleteUsagePolicy(usagePolicyDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.DEL_FAIL.name(),HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.DEL_SUCCESS.name(),HttpStatus.OK);
	}
}
