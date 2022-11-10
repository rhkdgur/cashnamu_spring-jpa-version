package cashnamu.cashnamu_v2.www.modules.information.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cashnamu.cashnamu_v2.www.modules.information.notice.service.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{}
