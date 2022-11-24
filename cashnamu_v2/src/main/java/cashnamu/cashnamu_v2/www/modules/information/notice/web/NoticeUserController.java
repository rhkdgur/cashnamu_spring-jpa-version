package cashnamu.cashnamu_v2.www.modules.information.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cashnamu.cashnamu_v2.www.modules.information.notice.dto.NoticeDTO;
import cashnamu.cashnamu_v2.www.modules.information.notice.service.NoticeService;

@RestController
public class NoticeUserController {
	
	@Autowired
	private NoticeService noticeService;

	/**
	 * 목록 조회
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/notice/list")
	public Page<NoticeDTO> selectNoticeList(Pageable pageable) throws Exception {
		return noticeService.findAll(pageable);
	}
	
	/**
	 * 상세 조회
	 * @param noticeDTO
	 * @return
	 * @throws Exception
	 */
	@GetMapping("notice/view")
	public NoticeDTO viewNotice(NoticeDTO noticeDTO) throws Exception {
		return noticeService.findOne(noticeDTO);
	}
}
