package cashnamu.cashnamu_v2.www.modules.information.faq.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Long insertFaq(FaqDTO faqDTO) throws Exception{
		Faq faq = faqDTO.toEntity();
		faqRepository.save(faq);
		return faq.getIdx();
	}
	
	/**수정*/
	@Transactional
	public void updateFaq(FaqDTO faqDTO) throws Exception{
		Faq prev = faqDTO.toEntity();
		prev = faqRepository.findById(prev.getIdx()).get();
		prev = faqDTO.toEntity();
		faqRepository.save(prev);
	}
	
	/**삭제*/
	@Transactional
	public void deleteFaq(FaqDTO faqDTO) throws Exception{
		faqRepository.deleteById(faqDTO.getIdx());
	}
	
	/**상세 조회*/
	@Transactional(readOnly = true)
	public FaqDTO findOne(FaqDTO faqDTO) throws Exception{
		return new FaqDTO(faqRepository.findById(faqDTO.getIdx()).get()); 
	}
	
	/**전체 목록 조회*/
	@Transactional(readOnly = true)
	public Page<FaqDTO> findAll(FaqDTO faqDTO,Pageable pageable) throws Exception{
		Page<Faq> list = faqRepository.findAll(pageable);
		return list.map(m->new FaqDTO(m));
	}

	/**구분값 기준 페이징*/
	@Transactional(readOnly = true)
	public Page<FaqDTO> findAllByGubun(FaqDTO faqDTO, Pageable pageable) throws Exception{
		Page<Faq> list = faqRepository.findByGubun(faqDTO.getGubun(),pageable);
		return list.map(m->new FaqDTO(m));
	}
}
