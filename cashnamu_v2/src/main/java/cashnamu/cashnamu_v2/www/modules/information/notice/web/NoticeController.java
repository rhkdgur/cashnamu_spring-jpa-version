package cashnamu.cashnamu_v2.www.modules.information.notice.web;

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
import cashnamu.cashnamu_v2.www.modules.information.notice.dto.NoticeDTO;
import cashnamu.cashnamu_v2.www.modules.information.notice.service.NoticeService;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.modules.information.notice.web
* @fileName        : NoticeController.java
* @author        : rhkdg
* @description : 공지사항(관리자)
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.24	고광혁			최초생성
 */
@RestController
public class NoticeController extends BaseController{

	@Autowired
	private NoticeService noticeService;
	
	
	/**
	 * 목록 조회
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/notice/list")
	public Page<NoticeDTO> selectNoticeList(Pageable pageable) throws Exception {
		return noticeService.findAll(pageable);
	}
	
	/**
	 * 상세 조회
	 * @param noticeDTO
	 * @return
	 * @throws Exception
	 */
	@GetMapping(MGN_URL+"/notice/view")
	public NoticeDTO viewNotice(NoticeDTO noticeDTO) throws Exception {
		return noticeService.findOne(noticeDTO);
	}
	
	/**
	 * 등록
	 * @param noticeDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/notice/act/ins")
	public ResponseEntity<String> insertNotice(NoticeDTO noticeDTO,SessionStatus status) throws Exception {
		
		try {
			noticeService.insertNotice(noticeDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.INS_FAIL.getDisplay(), HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.INS_SUCCESS.getDisplay(), HttpStatus.OK);
	}
	
	/**
	 * 수정
	 * @param noticeDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/notice/act/upd")
	public ResponseEntity<String> updateNotice(NoticeDTO noticeDTO,SessionStatus status) throws Exception {
		
		try {
			noticeService.updateNotice(noticeDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.UPD_FAIL.getDisplay(), HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.UPD_SUCCESS.getDisplay(), HttpStatus.OK);
	}
	
	/**
	 * 삭제
	 * @param noticeDTO
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PostMapping(MGN_URL+"/notice/act/del")
	public ResponseEntity<String> deleteNotice(NoticeDTO noticeDTO,SessionStatus status) throws Exception {
		
		try {
			noticeService.deleteNotice(noticeDTO);
		}catch (Exception e) {
			return new ResponseEntity<String>(ResponseResultType.DEL_FAIL.getDisplay(), HttpStatus.BAD_REQUEST);
		}
		
		status.setComplete();
		return new ResponseEntity<String>(ResponseResultType.DEL_SUCCESS.getDisplay(), HttpStatus.OK);
	}
}
