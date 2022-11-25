package cashnamu.cashnamu_v2.www.cms.publiccode.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import cashnamu.cashnamu_v2.www.BaseController;
import cashnamu.cashnamu_v2.www.ResponseResultType;
import cashnamu.cashnamu_v2.www.cms.publiccode.dto.PublicCodeDTO;
import cashnamu.cashnamu_v2.www.cms.publiccode.service.PublicCodeService;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.cms.publiccode.web
* @fileName        : PublicCodeController.java
* @author        : rhkdg
* @description : 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.25	고광혁			최초생성
 */
@RestController
public class PublicCodeController extends BaseController{

	@Autowired
	private PublicCodeService publicCodeService;
	
	/**
	 * 목록 조회
	 * @param publicCodeDTO
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/public/code/list")
	public Page<PublicCodeDTO> selectPublicCodeList(PublicCodeDTO publicCodeDTO, Pageable pageable) throws Exception {
		return publicCodeService.selectPublicCodeList(pageable);
	}
	
	/**
	 * 상세 조회
	 * @param publicCodeDTO
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/public/code/view")
	public PublicCodeDTO viewPublicCode(PublicCodeDTO publicCodeDTO) throws Exception {
		return publicCodeService.selectPublicCode(publicCodeDTO);
	}
	
	/**
	 * 등록,수정
	 * @param publicCodeDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/public/code/act/ins")
	public ResponseEntity<String> savePublicCode(PublicCodeDTO publicCodeDTO, SessionStatus status) throws Exception {
		
		try{
			publicCodeService.savePublicCode(publicCodeDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.INS_FAIL.getDisplay(),HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.INS_SUCCESS.getDisplay(),HttpStatus.OK);
	}
	
	/**
	 * 삭제
	 * @param publicCodeDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/public/code/act/del")
	public ResponseEntity<String> deletePublicCode(PublicCodeDTO publicCodeDTO, SessionStatus status) throws Exception {
		
		try {
			publicCodeService.deletePublicCode(publicCodeDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.DEL_FAIL.getDisplay(),HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.DEL_SUCCESS.getDisplay(),HttpStatus.OK);
	}
}
