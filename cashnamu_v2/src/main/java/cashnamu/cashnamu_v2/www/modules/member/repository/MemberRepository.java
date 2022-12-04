package cashnamu.cashnamu_v2.www.modules.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cashnamu.cashnamu_v2.www.modules.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	Member findByIdAndDkey(String memberId, String dkey);
	
	/**최근 접속 시간 업데이트*/
	@Query("update member a set a.final_connect_time = sysdate() where a.dkey = :dkey")
	void recentConnectUpdate(String dkey);
}
