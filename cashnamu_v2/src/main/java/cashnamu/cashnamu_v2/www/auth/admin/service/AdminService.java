package cashnamu.cashnamu_v2.www.auth.admin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
		if(!MsgValidateMemberType.NONE.equals(validateJoinAdmin(admin))) {
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
	public List<AdminDTO> findByAdmins(){
		List<Admin> list = adminRepository.findAll();
		return list.stream().map(m->new AdminDTO(m.getAdminId(),m.getAdminPw(),m.getAdminName(),m.getAccess(),m.getPageAccess(),m.getCreateDate())).collect(Collectors.toList());
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
	public void deleteAdmin(Admin admin) {
		adminRepository.deleteById(admin.getAdminId());
	}
	
	/**
	 * 회원 가입 중복 체크
	 * @param admin
	 * @return
	 */
	private MsgValidateMemberType validateJoinAdmin(Admin admin) {
		if(!adminRepository.findById(admin.getAdminId()).isEmpty()) {
			return MsgValidateMemberType.OVERLAP;
		}else {
			return MsgValidateMemberType.NONE;
		}
	}
}
