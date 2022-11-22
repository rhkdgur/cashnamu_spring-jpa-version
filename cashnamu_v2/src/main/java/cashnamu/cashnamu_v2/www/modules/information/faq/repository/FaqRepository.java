package cashnamu.cashnamu_v2.www.modules.information.faq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cashnamu.cashnamu_v2.www.modules.information.faq.domain.Faq;
import cashnamu.cashnamu_v2.www.modules.information.faq.service.FaqGubunType;

public interface FaqRepository extends JpaRepository<Faq, Long>{
	
	List<Faq> findByGubun(FaqGubunType gubun);
	
}
