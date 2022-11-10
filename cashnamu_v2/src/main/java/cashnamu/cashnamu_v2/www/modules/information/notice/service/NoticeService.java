package cashnamu.cashnamu_v2.www.modules.information.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.modules.information.notice.repository.NoticeRepository;

@Service
public class NoticeService {

	@Autowired
	NoticeRepository noticeRepository;
	
	/**목록 조회*/
	@Transactional(readOnly = true)
	public Page<Notice> findAll(Pageable pageable){
		return noticeRepository.findAll(pageable);
	}
	
	/**상세조회*/
	@Transactional(readOnly = true)
	public Notice findOne(Notice notice) {
		return noticeRepository.findById(notice.getIdx()).get();
	}
	
	/**등록*/
	@Transactional
	public void insertNotice(Notice notice) {
		noticeRepository.save(notice);
	}
	
	/**수정*/
	@Transactional
	public void updateNotice(Notice notice) {
		Notice prev = new Notice();
		prev.setIdx(notice.getIdx());
		prev = noticeRepository.findById(prev.getIdx()).get();
		prev.setTitle(notice.getTitle());
		prev.setContent(notice.getContent());
		noticeRepository.save(prev);
	}
	
	/**삭제*/
	@Transactional
	public void deleteNotice(Notice notice) {
		noticeRepository.deleteById(notice.getIdx());
	}
	
	/**조회수 증가*/
	@Transactional
	public void viewPlusInsert(Notice notice) {
		notice = noticeRepository.findById(notice.getIdx()).get();
		int view = notice.getView()+1;
		notice.setView(view);
		noticeRepository.save(notice);
	}
}
