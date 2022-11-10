package cashnamu.cashnamu_v2.www.modules.information.faq.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cashnamu.cashnamu_v2.www.modules.information.faq.service.Faq;
import cashnamu.cashnamu_v2.www.modules.information.faq.service.FaqGubunType;

public interface FaqRepository extends JpaRepository<Faq, Long>{
	
	Page<Faq> findByGubun(FaqGubunType gubun, Pageable pageable);
	
}
