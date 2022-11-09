package cashnamu.cashnamu_v2.www.modules.member.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

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
@Getter @Setter
public class Member {

	/**회원 아이디*/
	@Id @Column(name="member_id",length = 80)
	private String id;
	
	/**회원 고유키값*/
	private String dkey;
	
	/**전화번호*/
	@Column(length = 80)
	private String phoneNumber;
	
	/**이름*/
	@Column(length = 30)
	private String name;
	
	/**사용자 포인트*/
	@Column(nullable = true)
	private int point;
	
	/** 사용자 활성화 상태*/
	@Column(nullable = true)
	private int status;
	
	/** 로그인 구분*/
	@Enumerated(EnumType.STRING)
	@Column(name="gubun")
	private LoginGubunType gubun;
	
	/** 성별*/
	@Column(length = 2)
	private String gender;
	
	/** 생일*/
	@Column(length = 30)
	private String birthDay;
	
	/** 본인인증 키*/
	@Column(length = 100)
	private String authKey;
	
	/**은행명*/
	@Column(length = 10)
	private String bankName;
	
	/**예금주*/
	@Column(length = 10)
	private String accountName;	
	
	/**계좌번호*/
	@Column(length = 50)
	private String accountNumber;
	
	/**최근 접속 일자*/
	@Temporal(TemporalType.TIMESTAMP)
	private Date finalConnectTime;
	
	/**등록 일자*/
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
}
