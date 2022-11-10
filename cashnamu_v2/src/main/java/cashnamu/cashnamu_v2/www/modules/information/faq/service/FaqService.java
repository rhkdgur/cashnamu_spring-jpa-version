package cashnamu.cashnamu_v2.www.modules.information.faq.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.modules.information.faq.repository.FaqRepository;

@Service
public class FaqService {

	@Autowired
	private FaqRepository faqRepository;
	
	/**FAQ 등록*/
	@Transactional
	public Long insertFaq(Faq faq) {
		faqRepository.save(faq);
		return faq.getIdx();
	}
	
	/**수정*/
	@Transactional
	public void updateFaq(Faq faq) {
		Faq prev = new Faq();
		prev.setIdx(faq.getIdx());
		prev = faqRepository.findById(faq.getIdx()).get();
		prev.setTitle(faq.getTitle());
		prev.setContent(faq.getContent());
		prev.setGubun(faq.getGubun());
		faqRepository.save(prev);
	}
	
	/**삭제*/
	@Transactional
	public void deleteFaq(Faq faq) {
		faqRepository.deleteById(faq.getIdx());
	}
	
	/**상세 조회*/
	@Transactional(readOnly = true)
	public Faq findOne(Faq faq) {
		return faqRepository.findById(faq.getIdx()).get(); 
	}
	
	/**전체 목록 조회*/
	@Transactional(readOnly = true)
	public List<Faq> findAll(Faq faq){
		return faqRepository.findAll();
	}

	/**구분값 기준 페이징*/
	@Transactional(readOnly = true)
	public Page<Faq> findAllByGubun(Faq faq,Pageable pageable){
		return faqRepository.findByGubun(faq.getGubun(), pageable);
	}
}
