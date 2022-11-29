package cashnamu.cashnamu_v2.www.modules.information.usagepolicy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cashnamu.cashnamu_v2.www.modules.information.usagepolicy.domain.UsagePolicy;

public interface UsagePolicyRepository extends JpaRepository<UsagePolicy, Integer>{
	
	@Query(value="select u from usage_policy u where u.term_of_use is not null", nativeQuery=true)
	UsagePolicy selectUsage();
	
	@Query(value="select u from usage_policy u where u.privacy_policy is not null", nativeQuery=true)
	UsagePolicy selectPolicy();
}
