package cashnamu.cashnamu_v2.www.modules.information.usagepolicy.service;

import javax.transaction.TransactionScoped;

import org.jboss.jandex.TypeTarget.Usage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.modules.information.usagepolicy.dto.UsagePolicyDTO;
import cashnamu.cashnamu_v2.www.modules.information.usagepolicy.repository.UsagePolicyRepository;

@Service
@Transactional(readOnly = true)
public class UsagePolicyService {

	@Autowired
	private UsagePolicyRepository usagePolicyRepository;
	
	/**
	 * 이용약관 조회
	 * @return
	 * @throws Exception
	 */
	public UsagePolicyDTO selectUsage() throws Exception{
		return new UsagePolicyDTO(usagePolicyRepository.selectUsage());
	}
	
	/**
	 * 개인정보 처리 방침 조회
	 * @return
	 * @throws Exception
	 */
	public UsagePolicyDTO selectPolicy() throws Exception{
		return new UsagePolicyDTO(usagePolicyRepository.selectPolicy());
	}
	
	/**
	 * 등록,수정
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public UsagePolicyDTO saveUsagePolicy(UsagePolicyDTO dto) throws Exception{
		return new UsagePolicyDTO(usagePolicyRepository.save(dto.toEntity()));
	}
	
	/**
	 * 삭제
	 * @param dto
	 * @throws Exception
	 */
	@Transactional
	public void deleteUsagePolicy(UsagePolicyDTO dto) throws Exception {
			usagePolicyRepository.delete(dto.toEntity());
	}
}
