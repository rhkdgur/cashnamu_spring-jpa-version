package cashnamu.cashnamu_v2.www.auth.admin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cashnamu.cashnamu_v2.www.auth.admin.service.Admin;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.modules.auth.admin.repository
* @fileName        : AdminRepository.java
* @author        : rhkdg
* @description : 관리자 리포지토리
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.16	고광혁			최초생성
 */
public interface AdminRepository extends JpaRepository<Admin, String>,AdminCustomRepository{

	Page<Admin> findByAdminName(String adminName,Pageable pageable);

}
