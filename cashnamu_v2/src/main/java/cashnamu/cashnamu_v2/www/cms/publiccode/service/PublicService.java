package cashnamu.cashnamu_v2.www.cms.publiccode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cashnamu.cashnamu_v2.www.cms.publiccode.dto.PublicCodeDTO;
import cashnamu.cashnamu_v2.www.cms.publiccode.repository.PublicCodeRepository;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.cms.publiccode.service
* @fileName        : PublicService.java
* @author        : rhkdg
* @description : 공통코드관리 서비스 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.25	고광혁			최초생성
 */
@Service
public class PublicService {

	@Autowired
	private PublicCodeRepository publicCodeRepository;
	
	/**
	 * 목록 조회
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	public Page<PublicCodeDTO> selectPublicCodeList(Pageable pageable) throws Exception {
		return publicCodeRepository.findAll(pageable).map(m->new PublicCodeDTO(m));
	}
	
	/**
	 * 상세 조회
	 * @param publicCodeDTO
	 * @return
	 * @throws Exception
	 */
	public PublicCodeDTO selectPublicCode(PublicCodeDTO publicCodeDTO) throws Exception {
		return new PublicCodeDTO(publicCodeRepository.findById(publicCodeDTO.getPubCd()).get());
	}
	
}
