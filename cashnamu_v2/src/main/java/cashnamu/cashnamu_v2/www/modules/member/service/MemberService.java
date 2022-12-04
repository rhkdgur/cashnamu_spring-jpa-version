package cashnamu.cashnamu_v2.www.modules.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cashnamu.cashnamu_v2.www.modules.member.domain.Member;
import cashnamu.cashnamu_v2.www.modules.member.dto.MemberDTO;
import cashnamu.cashnamu_v2.www.modules.member.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	/**
	 * 목록 조회
	 * @param memberDTO
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	public Page<MemberDTO> selectMemberList(MemberDTO memberDTO,Pageable pageable) throws Exception {
		return memberRepository.findAll(pageable).map(MemberDTO::new);
	}
	
	/**
	 * 상세 조회
	 * @param memberDTO
	 * @return
	 * @throws Exception
	 */
	public MemberDTO selectMember(MemberDTO memberDTO) throws Exception {
		return new MemberDTO(memberRepository.findByIdAndDkey(memberDTO.getId(), memberDTO.getDkey()));
	}
	
	/**
	 * 등록 처리
	 * @param memberDTO
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public MemberDTO saveMember(MemberDTO memberDTO) throws Exception{
		return new MemberDTO(memberRepository.save(Member.ByMemberDTOBuild().memberDTO(memberDTO).build()));
	}
	
	/**
	 * 수정
	 * @param memberDTO
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@Transactional
	public void updateMember(MemberDTO memberDTO) throws Exception {
	  Member member = memberRepository.findByIdAndDkey(memberDTO.getId(), memberDTO.getDkey());
	  member = Member.ByMemberDTOBuild().memberDTO(memberDTO).build();
	}
	
	/**
	 * 삭제
	 * @param memberDTO
	 * @throws Exception
	 */
	@Transactional
	public void deleteMember(MemberDTO memberDTO) throws Exception {
		Member member = Member.ByMemberDTOBuild().memberDTO(memberDTO).build();
		memberRepository.delete(member);
	}
	
	
	@Transactional
	public void updateFinalConnectTime(MemberDTO memberDTO) throws Exception {
		memberRepository.recentConnectUpdate(memberDTO.getDkey());
	}
}
