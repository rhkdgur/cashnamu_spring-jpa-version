package cashnamu.cashnamu_v2.www.modules.information.faq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import cashnamu.cashnamu_v2.www.BaseController;
import cashnamu.cashnamu_v2.www.ResponseResultType;
import cashnamu.cashnamu_v2.www.modules.information.faq.dto.FaqDTO;
import cashnamu.cashnamu_v2.www.modules.information.faq.service.FaqService;

@RestController
public class FaqController extends BaseController{

	@Autowired
	private FaqService faqService;
	
	/**
	 * 목록 조회
	 * @param faqDTO
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/faq/list")
	public Page<FaqDTO> selectFaqList(FaqDTO faqDTO,Pageable pageable) throws Exception {
		
		//최신순 조회
		PageRequest pageRequest  = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("createDate").descending());
		Page<FaqDTO> resultList = faqService.findAll(faqDTO,pageRequest);
		
		return resultList;
	}
	
	/**
	 * 상세 조회
	 * @param faqDTO
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/faq/view")
	public FaqDTO viewFaq(FaqDTO faqDTO) throws Exception {
		return faqService.findOne(faqDTO);
	}
	
	/**
	 * 등록
	 * @param faqDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/faq/action/ins")
	public ResponseEntity<String> insertFaq(FaqDTO faqDTO,SessionStatus status) throws Exception {
		
		try {
			faqService.insertFaq(faqDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.INS_FAIL.getDisplay(), HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.INS_SUCCESS.getDisplay(), HttpStatus.OK);
	}
	
	/**
	 * 삭제
	 * @param faqDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/faq/action/del")
	public ResponseEntity<String> deleteFaq(FaqDTO faqDTO,SessionStatus status) throws Exception{
		
		try {
			faqService.deleteFaq(faqDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.DEL_FAIL.getDisplay(), HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.DEL_SUCCESS.getDisplay(), HttpStatus.OK);
	}
}
