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
public class FaqUserController{

	@Autowired
	private FaqService faqService;
	
	/**
	 * 목록 조회
	 * @param faqDTO
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/faq/list")
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
	@GetMapping("/faq/view")
	public FaqDTO viewFaq(FaqDTO faqDTO) throws Exception {
		return faqService.findOne(faqDTO);
	}
}
