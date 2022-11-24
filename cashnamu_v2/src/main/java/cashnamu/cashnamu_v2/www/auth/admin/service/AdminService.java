package cashnamu.cashnamu_v2.www.auth.admin.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.auth.admin.domain.Admin;
import cashnamu.cashnamu_v2.www.auth.admin.dto.AdminDTO;
import cashnamu.cashnamu_v2.www.auth.admin.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional
	public AdminDTO insert(AdminDTO adminDTO) {
		
		Admin admin = adminDTO.toEntity();
		if(!MsgValidateMemberType.NONE.equals(validateJoinAdmin(adminDTO))) {
			return null;
		}
		return new AdminDTO(adminRepository.save(admin));
	}
	
	/**
	 * 목록 조회
	 * @param pageable
	 * @return
	 */
	@Transactional
	public Page<AdminDTO> findByAdmins(Pageable pageable){
		Page<Admin> list = adminRepository.findAll(pageable);
		return list.map(m->new AdminDTO(m));
	}
	
	/**
	 * 상세 목록 조회
	 * @param admin
	 * @return
	 */
	@Transactional
	public AdminDTO findById(AdminDTO adminDTO) {
		Admin admin = adminDTO.toEntity();
		return new AdminDTO(adminRepository.findById(admin.getAdminId()).get());
	}
	
	/**수정 처리*/
	@Transactional
	public AdminDTO update(AdminDTO adminDTO) {
		Admin admin = adminDTO.toEntity();
		Admin prev = adminRepository.findById(admin.getAdminId()).get();
		prev = admin;
		return new AdminDTO(adminRepository.save(prev));
	}
	
	/**
	 * 삭제
	 * @param admin
	 */
	@Transactional
	public void deleteAdmin(AdminDTO adminDTO) {
		adminRepository.deleteById(adminDTO.getAdminId());
	}
	
	/**
	 * 회원 가입 중복 체크
	 * @param admin
	 * @return
	 */
	private MsgValidateMemberType validateJoinAdmin(AdminDTO adminDTO) {
		if(!adminRepository.findById(adminDTO.getAdminId()).isEmpty()) {
			return MsgValidateMemberType.OVERLAP;
		}else {
			return MsgValidateMemberType.NONE;
		}
	}
}
