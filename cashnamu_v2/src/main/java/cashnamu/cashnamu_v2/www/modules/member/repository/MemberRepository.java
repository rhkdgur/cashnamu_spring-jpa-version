package cashnamu.cashnamu_v2.www.modules.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cashnamu.cashnamu_v2.www.modules.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	Member findByIdAndDkey(String memberId, String dkey);
}
