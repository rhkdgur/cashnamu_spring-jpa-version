package cashnamu.cashnamu_v2.www.modules.information.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.modules.information.notice.domain.Notice;
import cashnamu.cashnamu_v2.www.modules.information.notice.dto.NoticeDTO;
import cashnamu.cashnamu_v2.www.modules.information.notice.repository.NoticeRepository;

@Service
public class NoticeService {

	@Autowired
	NoticeRepository noticeRepository;
	
	/**목록 조회*/
	@Transactional(readOnly = true)
	public Page<NoticeDTO> findAll(Pageable pageable) throws Exception{
		Page<Notice> list = noticeRepository.findAll(pageable);
		return list.map(m->new NoticeDTO(m));
	}
	
	/**상세조회*/
	@Transactional(readOnly = true)
	public NoticeDTO findOne(NoticeDTO noticeDTO) throws Exception{
		return new NoticeDTO(noticeRepository.findById(noticeDTO.getIdx()).get());
	}
	
	/**등록*/
	@Transactional
	public void insertNotice(NoticeDTO noticeDTO) throws Exception{
		noticeRepository.save(noticeDTO.toEntity());
	}
	
	/**수정*/
	@Transactional
	public void updateNotice(NoticeDTO noticeDTO) throws Exception{
		Notice prev = noticeDTO.toEntity();
		prev = noticeRepository.findById(prev.getIdx()).get();
		prev = noticeDTO.toEntity();
		noticeRepository.save(prev);
	}
	
	/**삭제*/
	@Transactional
	public void deleteNotice(NoticeDTO noticeDTO) throws Exception {
		noticeRepository.deleteById(noticeDTO.getIdx());
	}
	
	/**조회수 증가*/
	@Transactional
	public void viewPlusInsert(NoticeDTO noticeDTO) throws Exception{
		Notice notice = noticeRepository.findById(noticeDTO.getIdx()).get();
		int view = notice.getView()+1;
		noticeDTO.setView(view);
		noticeRepository.save(noticeDTO.toEntity());
	}
}
