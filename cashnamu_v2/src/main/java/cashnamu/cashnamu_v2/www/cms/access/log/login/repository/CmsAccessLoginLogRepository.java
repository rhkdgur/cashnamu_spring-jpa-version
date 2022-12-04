package cashnamu.cashnamu_v2.www.cms.access.log.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cashnamu.cashnamu_v2.www.cms.access.log.login.domain.CmsAccessLoginLog;

public interface CmsAccessLoginLogRepository extends JpaRepository<CmsAccessLoginLog, Long>{

}
