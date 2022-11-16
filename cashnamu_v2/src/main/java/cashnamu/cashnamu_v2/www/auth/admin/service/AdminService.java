package cashnamu.cashnamu_v2.www.auth.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.auth.admin.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional
	public Admin insert(Admin admin) {
		
		if(!MsgValidateMemberType.NONE.equals(validateJoinAdmin(admin))) {
			return null;
		}
		return adminRepository.save(admin);
	}
	
	/**
	 * 목록 조회
	 * @param pageable
	 * @return
	 */
	@Transactional
	public Page<Admin> findByAdmins(Pageable pageable){
		return adminRepository.findAll(pageable);
	}
	
	/**
	 * 상세 목록 조회
	 * @param admin
	 * @return
	 */
	@Transactional
	public Admin findById(Admin admin) {
		return adminRepository.findById(admin.getAdminId()).get();
	}
	
	/**수정 처리*/
	@Transactional
	public Admin update(Admin admin) {
		Admin prev = adminRepository.findById(admin.getAdminId()).get();
		prev = admin;
		return adminRepository.save(prev);
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
