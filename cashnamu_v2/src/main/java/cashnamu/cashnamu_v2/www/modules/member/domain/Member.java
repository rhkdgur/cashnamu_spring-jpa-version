package cashnamu.cashnamu_v2.www.modules.member.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cashnamu.cashnamu_v2.www.modules.member.dto.MemberDTO;
import cashnamu.cashnamu_v2.www.modules.member.service.LoginGubunType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.domain.member.service
* @fileName        : Member.java
* @author        : rhkdg
* @description : 회원정보
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.10	고광혁			최초생성
 */
@Entity
@Table(name="member")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Member {

	/**회원 아이디*/
	@Comment("회원 아이디")
	@Id @Column(name="member_id",length = 80)
	private String id;
	
	/**회원 고유키값*/
	@Comment("회원 키값")
	private String dkey;
	
	/**전화번호*/
	@Comment("전화번호")
	@Column(length = 80)
	private String phoneNumber;
	
	/**이름*/
	@Comment("이름")
	@Column(length = 30)
	private String name;
	
	/**사용자 포인트*/
	@Comment("사용자 포인트")
	@Column(nullable = true)
	private int point;
	
	/** 사용자 활성화 상태*/
	@Comment("사용자 활성화 상태")
	@Column(nullable = true)
	private int status;
	
	/** 로그인 구분*/
	@Enumerated(EnumType.STRING)
	@Comment("로그인 구분")
	@Column(name="gubun")
	private LoginGubunType gubun;
	
	/** 성별*/
	@Comment("성별")
	@Column(length = 2)
	private String gender;
	
	/** 생일*/
	@Column(length = 30)
	@Comment("생일")
	private String birthDay;
	
	/** 본인인증 키*/
	@Column(length = 100)
	@Comment("본인인증 키")
	private String authKey;
	
	/**은행정보*/
	@Embedded
	private Account account;
	
	/**최근 접속 일자*/
	@Comment("최근 접속 일자")
	@Temporal(TemporalType.TIMESTAMP)
	private Date finalConnectTime;
	
	/**등록 일자*/
	@CreatedDate
	@Comment("등록 일자")
	private Date createDate;

	// dto -> entity
	@Builder(builderMethodName = "ByMemberDTOBuild")
	public Member(MemberDTO memberDTO) {
		this.id = memberDTO.getId();
		this.dkey = memberDTO.getDkey();
		this.phoneNumber = memberDTO.getPhoneNumber();
		this.name = memberDTO.getName();
		this.point = memberDTO.getPoint();
		this.status = memberDTO.getStatus();
		this.gubun = memberDTO.getGubun();
		this.gender = memberDTO.getGender();
		this.birthDay = memberDTO.getBirthDay();
		this.authKey = memberDTO.getAuthKey();
		this.account = Account.ByBuildAccount()
				.bankName(memberDTO.getBankName())
				.accountName(memberDTO.getAccountName())
				.accountNumber(memberDTO.getAccountNumber()).build();
		this.finalConnectTime = memberDTO.getFinalConnectTime();
		this.createDate = memberDTO.getCreateDate();
	}
	
}
