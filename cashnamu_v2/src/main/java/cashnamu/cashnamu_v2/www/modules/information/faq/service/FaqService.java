package cashnamu.cashnamu_v2.www.modules.information.faq.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.modules.information.faq.domain.Faq;
import cashnamu.cashnamu_v2.www.modules.information.faq.dto.FaqDTO;
import cashnamu.cashnamu_v2.www.modules.information.faq.repository.FaqRepository;

@Service
public class FaqService {

	@Autowired
	private FaqRepository faqRepository;
	
	/**FAQ 등록*/
	@Transactional
	public Long insertFaq(FaqDTO faqDTO) {
		Faq faq = faqDTO.toEntity();
		faqRepository.save(faq);
		return faq.getIdx();
	}
	
	/**수정*/
	@Transactional
	public void updateFaq(FaqDTO faqDTO) {
		Faq prev = faqDTO.toEntity();
		prev = faqRepository.findById(prev.getIdx()).get();
		prev = faqDTO.toEntity();
		faqRepository.save(prev);
	}
	
	/**삭제*/
	@Transactional
	public void deleteFaq(FaqDTO faqDTO) {
		faqRepository.deleteById(faqDTO.getIdx());
	}
	
	/**상세 조회*/
	@Transactional(readOnly = true)
	public FaqDTO findOne(FaqDTO faqDTO) {
		return new FaqDTO(faqRepository.findById(faqDTO.getIdx()).get()); 
	}
	
	/**전체 목록 조회*/
	@Transactional(readOnly = true)
	public List<FaqDTO> findAll(FaqDTO faqDTO){
		List<Faq> list = faqRepository.findAll();
		return list.stream().map(m->new FaqDTO(m)).collect(Collectors.toList());
	}

	/**구분값 기준 페이징*/
	@Transactional(readOnly = true)
	public List<FaqDTO> findAllByGubun(Faq faq){
		List<Faq> list = faqRepository.findByGubun(faq.getGubun());
		return list.stream().map(m->new FaqDTO(m)).collect(Collectors.toList());
	}
}
