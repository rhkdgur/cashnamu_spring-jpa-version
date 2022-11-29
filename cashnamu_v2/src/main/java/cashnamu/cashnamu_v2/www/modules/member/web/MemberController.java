package cashnamu.cashnamu_v2.www.modules.member.web;

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
import cashnamu.cashnamu_v2.www.BaseResult;
import cashnamu.cashnamu_v2.www.ResponseResultType;
import cashnamu.cashnamu_v2.www.modules.member.dto.MemberDTO;
import cashnamu.cashnamu_v2.www.modules.member.service.MemberService;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.modules.member.web
* @fileName        : MemberController.java
* @author        : rhkdg
* @description : 회원 관리 컨트롤러
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.30	고광혁			최초생성
 */
@RestController
public class MemberController extends BaseController{

	@Autowired
	private MemberService memberService;
	
	/**
	 * 목록 조회
	 * @param memberDTO
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/members")
	public BaseResult<Page<MemberDTO>> selectMemberList(MemberDTO memberDTO, Pageable pageable) throws Exception {
		
		Page<MemberDTO> resultList = memberService.selectMemberList(memberDTO, pageable);
		
		return new BaseResult<Page<MemberDTO>>(resultList);
	}
	
	/**
	 * 상세 조회
	 * @param memberDTO
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/members/view")
	public BaseResult<MemberDTO> selectMember(MemberDTO memberDTO) throws Exception {
		
		memberDTO = memberService.selectMember(memberDTO);
		
		return new BaseResult<MemberDTO>(memberDTO);
	}
	
	/**
	 * 등록
	 * @param memberDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/members/act/ins")
	public ResponseEntity<String> insertMember(MemberDTO memberDTO, SessionStatus status) throws Exception {
		try {
			memberService.saveMember(memberDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.INS_FAIL.getDisplay(),HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.INS_SUCCESS.getDisplay(),HttpStatus.OK);
	}
	
	/**
	 * 수정
	 * @param memberDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/members/act/upd")
	public ResponseEntity<String> updateMember(MemberDTO memberDTO, SessionStatus status) throws Exception {
		try {
			memberService.updateMember(memberDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.UPD_FAIL.getDisplay(),HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.UPD_SUCCESS.getDisplay(),HttpStatus.OK);
	}
	
	/**
	 * 삭제
	 * @param memberDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/members/act/del")
	public ResponseEntity<String> deleteMember(MemberDTO memberDTO, SessionStatus status) throws Exception {
		try {
			memberService.deleteMember(memberDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.DEL_FAIL.getDisplay(),HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.DEL_SUCCESS.getDisplay(),HttpStatus.OK);
	}
}
